"""
Student Data Generator for SMS System
Generates 5000+ students with proper FK references to:
  - campuses (10 campuses, IDs 1-10)
  - standards (5 per campus = 50 total, IDs 1-50)
  - sections (3 per standard = 150 total, IDs 1-150)
  - academic_years (multiple years including historical)
Outputs: populate_dashboard_large.sql
"""

import random
import os
from datetime import date, timedelta

# ─────────────────────────────────────────────
# NAMES
# ─────────────────────────────────────────────
MALE_FIRST_NAMES = [
    "Muhammad", "Ahmad", "Ali", "Hassan", "Hussain", "Omar", "Usman",
    "Abdullah", "Ibrahim", "Ismail", "Yusuf", "Dawud", "Sulayman", "Musa",
    "Isa", "Yahya", "Idris", "Hamza", "Bilal", "Salman", "Khalid", "Tariq",
    "Zaid", "Saad", "Faisal", "Imran", "Asad", "Adil", "Waqar", "Kamran",
    "Noman", "Aamir", "Zubair", "Talha", "Raza", "Zain", "Mustafa", "Haris",
    "Junaid", "Fahad", "Waleed", "Shahid", "Nasir", "Sajid", "Majid", "Rafiq",
    "Atif", "Badar", "Aqib", "Umair", "Saifullah", "Abdurrahman", "Zahid",
    "Mubashir", "Furqan", "Shoaib", "Luqman", "Haroon", "Nadir", "Rayyan",
]

FEMALE_FIRST_NAMES = [
    "Fatima", "Aisha", "Maryam", "Zainab", "Khadijah", "Ruqayyah", "Hafsa",
    "Sana", "Sara", "Amna", "Ayesha", "Hina", "Dua", "Zoya", "Noor", "Rania",
    "Layla", "Huda", "Asma", "Samira", "Rabia", "Naima", "Farida", "Saira",
    "Bushra", "Lubna", "Shazia", "Fiza", "Mehwish", "Uzma", "Kanza", "Aliya",
    "Arwa", "Safiya", "Sumayyah", "Raheela", "Iqra", "Maira", "Nadia",
    "Shabana", "Shaista", "Fauzia", "Tuba", "Zahra", "Nusrat", "Muskan",
    "Sidra", "Misbah", "Umm Kulthum", "Sawda",
]

LAST_NAMES = [
    "Khan", "Ahmed", "Ali", "Shah", "Malik", "Qureshi", "Siddiqui", "Sheikh",
    "Baig", "Javed", "Hussain", "Butt", "Raza", "Abbas", "Dar", "Mughal",
    "Farooqi", "Mansoor", "Lodhi", "Zahra", "Guijar", "Ansari", "Aslam",
    "Chaudhry", "Bhatti", "Mirza", "Rajput", "Niazi", "Hashmi", "Gilani",
    "Bokhari", "Naqvi", "Rizvi", "Tirmizi", "Khawaja", "Bhutto", "Akhtar",
    "Rauf", "Latif", "Sattar", "Hameed", "Rashid", "Waheed", "Karimi",
    "Awan", "Gondal", "Tahir", "Nawaz", "Saleem", "Rehman",
]

# ─────────────────────────────────────────────
# CAMPUS / STANDARD / SECTION MAPPING
# Based on Final_SMS_DATA.sql:
#   Campuses: IDs 1-10
#   Standards: 5 per campus (IDs 1-50)
#     campus_id 1 → standard_ids 1-5
#     campus_id 2 → standard_ids 6-10
#     ...
#     campus_id n → standard_ids (n-1)*5+1 .. n*5
#   Sections: 3 per standard (IDs 1-150)
#     standard_id s → section_ids (s-1)*3+1 .. s*3
#     NOTE: section 1 (first of std 1) has deleted=1, so we use ids 2,3 for std 1
# ─────────────────────────────────────────────
NUM_CAMPUSES = 10
STANDARDS_PER_CAMPUS = 5
SECTIONS_PER_STANDARD = 3  # sections A, B, C

def get_standard_ids_for_campus(campus_id: int) -> list[int]:
    start = (campus_id - 1) * STANDARDS_PER_CAMPUS + 1
    return list(range(start, start + STANDARDS_PER_CAMPUS))

def get_section_ids_for_standard(standard_id: int) -> list[int]:
    start = (standard_id - 1) * SECTIONS_PER_STANDARD + 1
    sections = list(range(start, start + SECTIONS_PER_STANDARD))
    # Section ID 1 is deleted in the seed data, skip it
    return [s for s in sections if s != 1]

# ─────────────────────────────────────────────
# ACADEMIC YEARS (will be inserted by the script)
# We define 5 academic years covering 2021-2026
# ─────────────────────────────────────────────
ACADEMIC_YEARS = [
    # (name, code, start_date, end_date, is_current)
    ("Academic Year 2021-2022", "AY2021", "2021-04-01", "2022-03-31", False),
    ("Academic Year 2022-2023", "AY2022", "2022-04-01", "2023-03-31", False),
    ("Academic Year 2023-2024", "AY2023", "2023-04-01", "2024-03-31", False),
    ("Academic Year 2024-2025", "AY2024", "2024-04-01", "2025-03-31", False),
    ("Academic Year 2025-2026", "AY2025", "2025-04-01", "2026-03-31", True),
]
# AY IDs will be 2,3,4,5 (id=1 already exists as AY2025 from seed data)
# We'll use INSERT IGNORE / ON DUPLICATE KEY UPDATE to be safe
# And use subqueries to reference them by code

# ─────────────────────────────────────────────
# HELPERS
# ─────────────────────────────────────────────
def random_dob(grade_offset: int) -> str:
    """Generate a date of birth consistent with a student's grade."""
    # Base age: grade 1 = ~6 yrs, grade 5 = ~10 yrs  (born 2010-2020)
    base_age = 6 + grade_offset
    current_year = 2026
    birth_year = current_year - base_age - random.randint(0, 1)
    birth_month = random.randint(1, 12)
    birth_day = random.randint(1, 28)
    return f"{birth_year:04d}-{birth_month:02d}-{birth_day:02d}"

def random_enrollment_date(ay_start: str, ay_end: str) -> str:
    """Pick a random date within the first 4 months of the academic year."""
    start = date.fromisoformat(ay_start)
    enroll_end = start + timedelta(days=120)
    delta = (enroll_end - start).days
    random_days = random.randint(0, delta)
    d = start + timedelta(days=random_days)
    return d.strftime("%Y-%m-%d")

# ─────────────────────────────────────────────
# MAIN GENERATOR
# ─────────────────────────────────────────────
TOTAL_STUDENTS = 5500  # slightly above 5000 to ensure we hit target

random.seed(42)

lines = []

# Header
lines.append("-- ============================================================")
lines.append("-- Large Scale Student Population Script (5500 students)")
lines.append("-- Generated automatically by generate_students.py")
lines.append("-- Covers Academic Years 2021-2026")
lines.append("-- Campus IDs: 1-10  |  Standards: 5 per campus  |  Sections: 3 per standard")
lines.append("-- ============================================================")
lines.append("")
lines.append("SET SQL_SAFE_UPDATES = 0;")
lines.append("")

# ── INSERT ACADEMIC YEARS (skip if already exists) ──
lines.append("-- ============================================================")
lines.append("-- 1. Insert Historical Academic Years")
lines.append("-- ============================================================")
lines.append("INSERT INTO academic_years (name, code, start_date, end_date, total_months, is_current, status, organization_id)")
lines.append("VALUES")
ay_rows = []
for (name, code, start, end, is_cur) in ACADEMIC_YEARS:
    cur_val = "TRUE" if is_cur else "FALSE"
    ay_rows.append(f"    ('{name}', '{code}', '{start}', '{end}', 12, {cur_val}, 'ACTIVE', 1)")
lines.append(",\n".join(ay_rows))
lines.append("ON DUPLICATE KEY UPDATE name = VALUES(name), is_current = VALUES(is_current);")
lines.append("")

# ── Build distribution: students per campus/standard/section/ay ──
# We want to spread students across:
#   10 campuses × 5 standards × (2 or 3) sections × 5 academic years
# That's 10×5×~2.5×5 = 1250 cells; each cell averages ~4.4 students

# Map ay index (0-4) → code string
AY_CODES = [ay[1] for ay in ACADEMIC_YEARS]
AY_DATES = [(ay[2], ay[3]) for ay in ACADEMIC_YEARS]  # (start, end)

# Build student rows
student_rows = []
seq = 0

# Distribution weights per academic year (more students in recent years)
ay_weights = [0.10, 0.15, 0.18, 0.25, 0.32]

# Total students to assign per AY
ay_counts = [int(TOTAL_STUDENTS * w) for w in ay_weights]
ay_counts[-1] += TOTAL_STUDENTS - sum(ay_counts)  # fix rounding

for ay_idx, (ay_code, ay_count) in enumerate(zip(AY_CODES, ay_counts)):
    ay_start, ay_end = AY_DATES[ay_idx]
    
    students_placed = 0
    campus_ids = list(range(1, NUM_CAMPUSES + 1))
    random.shuffle(campus_ids)
    
    per_campus = ay_count // NUM_CAMPUSES
    extra = ay_count % NUM_CAMPUSES
    
    for ci, campus_id in enumerate(campus_ids):
        campus_count = per_campus + (1 if ci < extra else 0)
        std_ids = get_standard_ids_for_campus(campus_id)
        random.shuffle(std_ids)
        
        per_std = campus_count // len(std_ids)
        extra_std = campus_count % len(std_ids)
        
        for si, std_id in enumerate(std_ids):
            std_count = per_std + (1 if si < extra_std else 0)
            sec_ids = get_section_ids_for_standard(std_id)
            if not sec_ids:
                continue
            
            per_sec = std_count // len(sec_ids)
            extra_sec = std_count % len(sec_ids)
            
            for ki, sec_id in enumerate(sec_ids):
                sec_count = per_sec + (1 if ki < extra_sec else 0)
                
                # Grade offset for DOB (0=1st grade, 4=5th grade)
                grade_offset = std_ids.index(std_id) if std_id in std_ids else 2
                
                for _ in range(sec_count):
                    gender = random.choice(["MALE", "FEMALE"])
                    if gender == "MALE":
                        first = random.choice(MALE_FIRST_NAMES)
                    else:
                        first = random.choice(FEMALE_FIRST_NAMES)
                    last = random.choice(LAST_NAMES)
                    full = f"{first} {last}"
                    
                    code_str = f"STU-{seq:05d}-{random.randint(1000,9999)}"
                    dob = random_dob(grade_offset)
                    enroll_date = random_enrollment_date(ay_start, ay_end)
                    is_active = 1 if ay_idx == len(AY_CODES) - 1 else random.choice([1, 1, 0])
                    
                    student_rows.append(
                        f"    ('{first}', '{last}', '{full}', '{code_str}', '{dob}', "
                        f"'{gender}', '{enroll_date}', {is_active}, 0, "
                        f"{campus_id}, {std_id}, {sec_id}, "
                        f"(SELECT id FROM admission_type LIMIT 1), "
                        f"(SELECT id FROM academic_years WHERE code='{ay_code}' LIMIT 1), "
                        f"1, NOW())"
                    )
                    seq += 1

random.shuffle(student_rows)

# ── Write in batches of 500 for MySQL performance ──
BATCH_SIZE = 500
INSERT_HEADER = (
    "INSERT INTO students "
    "(first_name, last_name, full_name, student_code, date_of_birth, gender, "
    "enrollment_date, is_active, deleted, campus_id, standard_id, section_id, "
    "admission_type_id, academic_year_id, organization_id, created_at)\nVALUES"
)

lines.append("-- ============================================================")
lines.append(f"-- 2. Insert {len(student_rows)} Students")
lines.append("-- ============================================================")
lines.append("")

for batch_start in range(0, len(student_rows), BATCH_SIZE):
    batch = student_rows[batch_start: batch_start + BATCH_SIZE]
    batch_num = batch_start // BATCH_SIZE + 1
    lines.append(f"-- Batch {batch_num} (rows {batch_start+1}-{batch_start+len(batch)})")
    lines.append(INSERT_HEADER)
    lines.append(",\n".join(batch) + ";")
    lines.append("")

# ── Write to file ──
output_path = os.path.join(os.path.dirname(__file__), "..", "src", "main", "resources", "db", "populate_dashboard_large.sql")
output_path = os.path.normpath(output_path)

with open(output_path, "w", encoding="utf-8") as f:
    f.write("\n".join(lines))

print(f"✅ Generated {len(student_rows)} student records in {output_path}")
print(f"   Academic years: {[ay[1] for ay in ACADEMIC_YEARS]}")
print(f"   Campuses: 1-{NUM_CAMPUSES}")
print(f"   Standards: 1-{NUM_CAMPUSES * STANDARDS_PER_CAMPUS}")
print(f"   Sections: 1-{NUM_CAMPUSES * STANDARDS_PER_CAMPUS * SECTIONS_PER_STANDARD} (excl. deleted)")
print(f"   Total INSERT batches: {(len(student_rows) + BATCH_SIZE - 1) // BATCH_SIZE}")
