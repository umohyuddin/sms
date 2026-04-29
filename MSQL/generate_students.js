/**
 * Student Data Generator for SMS System — v2 (FK-safe)
 *
 * Root-cause fix:
 *   - Seed data only created sections for standards 1-10 (campuses 1 & 2).
 *   - Standards 11-50 (campuses 3-10) had NO sections → FK violation.
 *
 * Solution:
 *   1. INSERT sections (A/B/C) for standards 11-50 at top of SQL.
 *   2. Use subquery  (SELECT id FROM sections WHERE standard_id=X
 *                     AND deleted=0 ORDER BY id LIMIT 1 OFFSET Y)
 *      instead of hardcoded section IDs — works regardless of auto_increment gaps.
 *
 * Output: src/main/resources/db/populate_dashboard_large.sql
 */

const fs   = require('fs');
const path = require('path');

// ─── NAMES ────────────────────────────────────────────────────────────────────
const MALE_FIRST = [
  'Muhammad','Ahmad','Ali','Hassan','Hussain','Omar','Usman','Abdullah',
  'Ibrahim','Ismail','Yusuf','Dawud','Sulayman','Musa','Isa','Yahya',
  'Idris','Hamza','Bilal','Salman','Khalid','Tariq','Zaid','Saad',
  'Faisal','Imran','Asad','Adil','Waqar','Kamran','Noman','Aamir',
  'Zubair','Talha','Raza','Zain','Mustafa','Haris','Junaid','Fahad',
  'Waleed','Shahid','Nasir','Sajid','Majid','Rafiq','Atif','Badar',
  'Aqib','Umair','Saifullah','Abdurrahman','Zahid','Mubashir','Furqan',
  'Shoaib','Luqman','Haroon','Nadir','Rayyan','Talal','Muneeb','Khurram',
  'Jawad','Rizwan','Shehzad','Tariq','Yasir','Zeeshan','Arslan','Daniyal',
];

const FEMALE_FIRST = [
  'Fatima','Aisha','Maryam','Zainab','Khadijah','Ruqayyah','Hafsa',
  'Sana','Sara','Amna','Ayesha','Hina','Dua','Zoya','Noor','Rania',
  'Layla','Huda','Asma','Samira','Rabia','Naima','Farida','Saira',
  'Bushra','Lubna','Shazia','Fiza','Mehwish','Uzma','Kanza','Aliya',
  'Arwa','Safiya','Sumayyah','Raheela','Iqra','Maira','Nadia','Shabana',
  'Shaista','Fauzia','Tuba','Zahra','Nusrat','Muskan','Sidra','Misbah',
  'Sawda','Rukhsar','Nimra','Sadia','Anila','Tayyaba','Ghazala','Hajra',
  'Nafeesa','Aneesa','Farwa','Sobia','Mariam','Rehana','Shehla','Zara',
];

const LAST_NAMES = [
  'Khan','Ahmed','Ali','Shah','Malik','Qureshi','Siddiqui','Sheikh',
  'Baig','Javed','Hussain','Butt','Raza','Abbas','Dar','Mughal',
  'Farooqi','Mansoor','Lodhi','Zahra','Guijar','Ansari','Aslam',
  'Chaudhry','Bhatti','Mirza','Rajput','Niazi','Hashmi','Gilani',
  'Bokhari','Naqvi','Rizvi','Tirmizi','Khawaja','Bhutto','Akhtar',
  'Rauf','Latif','Sattar','Hameed','Rashid','Waheed','Karimi',
  'Awan','Gondal','Tahir','Nawaz','Saleem','Rehman','Nazir','Pervez',
  'Bajwa','Choudhry','Dogar','Gul','Haider','Irfan','Jaffar','Kayani',
];

// ─── CONFIGURATION ─────────────────────────────────────────────────────────────
const NUM_CAMPUSES          = 10;
const STANDARDS_PER_CAMPUS  = 5;
const SECTIONS_PER_STANDARD = 3;   // A, B, C
const TOTAL_STUDENTS        = 5500;
const BATCH_SIZE            = 500;

// Standards 1-10 already have sections from Final_SMS_DATA.sql seed.
// We must create sections for standards 11-50.
const FIRST_MISSING_STANDARD = 11;
const LAST_STANDARD          = NUM_CAMPUSES * STANDARDS_PER_CAMPUS; // 50

// Academic years
const ACADEMIC_YEARS = [
  { name:'Academic Year 2021-2022', code:'AY2021', start:'2021-04-01', end:'2022-03-31', isCurrent:false },
  { name:'Academic Year 2022-2023', code:'AY2022', start:'2022-04-01', end:'2023-03-31', isCurrent:false },
  { name:'Academic Year 2023-2024', code:'AY2023', start:'2023-04-01', end:'2024-03-31', isCurrent:false },
  { name:'Academic Year 2024-2025', code:'AY2024', start:'2024-04-01', end:'2025-03-31', isCurrent:false },
  { name:'Academic Year 2025-2026', code:'AY2025', start:'2025-04-01', end:'2026-03-31', isCurrent:true  },
];

// Distribution weights (older years → fewer students)
const AY_WEIGHTS = [0.10, 0.15, 0.18, 0.25, 0.32];

// ─── SEEDED RNG ────────────────────────────────────────────────────────────────
let seed = 42;
function seededRand() {
  seed = (seed * 1664525 + 1013904223) & 0xffffffff;
  return (seed >>> 0) / 0xffffffff;
}
function randInt(min, max) { return min + Math.floor(seededRand() * (max - min + 1)); }
function pick(arr)         { return arr[Math.floor(seededRand() * arr.length)]; }
function shuffle(arr) {
  const a = [...arr];
  for (let i = a.length - 1; i > 0; i--) {
    const j = Math.floor(seededRand() * (i + 1));
    [a[i], a[j]] = [a[j], a[i]];
  }
  return a;
}

// ─── FK-SAFE SECTION LOOKUP SUBQUERY ─────────────────────────────────────────
// secOffset: 0=A, 1=B, 2=C
function sectionSubquery(stdId, secOffset) {
  return `(SELECT id FROM sections WHERE standard_id=${stdId} AND deleted=0 ORDER BY id LIMIT 1 OFFSET ${secOffset})`;
}

// ─── HELPERS ──────────────────────────────────────────────────────────────────
function getStandardIds(campusId) {
  const start = (campusId - 1) * STANDARDS_PER_CAMPUS + 1;
  return Array.from({ length: STANDARDS_PER_CAMPUS }, (_, i) => start + i);
}

function randomDob(gradeOffset) {
  const baseAge = 6 + gradeOffset;
  const year    = 2026 - baseAge - randInt(0, 1);
  const month   = String(randInt(1, 12)).padStart(2, '0');
  const day     = String(randInt(1, 28)).padStart(2, '0');
  return `${year}-${month}-${day}`;
}

function randomEnrollDate(ayStart) {
  const start  = new Date(ayStart);
  const days   = randInt(0, 120);
  const result = new Date(start.getTime() + days * 86400000);
  const y = result.getFullYear();
  const m = String(result.getMonth() + 1).padStart(2, '0');
  const d = String(result.getDate()).padStart(2, '0');
  return `${y}-${m}-${d}`;
}

function escape(s) { return s.replace(/'/g, "\\'"); }

// ─── BUILD SQL ─────────────────────────────────────────────────────────────────
const lines = [];

lines.push('-- ============================================================');
lines.push(`-- Large Scale Student Population (${TOTAL_STUDENTS} students) — v2 FK-safe`);
lines.push('-- Generated by generate_students.js');
lines.push('-- Covers Academic Years 2021-2026  |  All 10 campuses');
lines.push('-- ============================================================');
lines.push('');
lines.push('SET SQL_SAFE_UPDATES = 0;');
lines.push('');

// ── STEP 1: Academic Years ─────────────────────────────────────────────────────
lines.push('-- ============================================================');
lines.push('-- STEP 1: Insert / Update Academic Years (2021-2026)');
lines.push('-- ============================================================');
lines.push('INSERT INTO academic_years');
lines.push('  (name, code, start_date, end_date, total_months, is_current, status, organization_id)');
lines.push('VALUES');
lines.push(
  ACADEMIC_YEARS
    .map(ay => `  ('${ay.name}', '${ay.code}', '${ay.start}', '${ay.end}', 12, ${ay.isCurrent ? 'TRUE' : 'FALSE'}, 'ACTIVE', 1)`)
    .join(',\n')
);
lines.push('ON DUPLICATE KEY UPDATE');
lines.push('  name       = VALUES(name),');
lines.push('  is_current = VALUES(is_current);');
lines.push('');

// ── STEP 2: Insert Missing Sections (standards 11-50) ─────────────────────────
lines.push('-- ============================================================');
lines.push('-- STEP 2: Insert Sections A/B/C for standards 11-50');
lines.push('--         (standards 1-10 already have sections from seed data)');
lines.push('-- ============================================================');
lines.push('INSERT INTO sections (organization_id, standard_id, section_name, created_at, updated_at, deleted, deleted_at)');
lines.push('VALUES');

const sectionRows = [];
for (let stdId = FIRST_MISSING_STANDARD; stdId <= LAST_STANDARD; stdId++) {
  ['A','B','C'].forEach(name => {
    sectionRows.push(`  (1, ${stdId}, '${name}', NOW(), NOW(), 0, NULL)`);
  });
}
lines.push(sectionRows.join(',\n') + ';');
lines.push('');

// ── STEP 3: Generate Student Rows ─────────────────────────────────────────────
lines.push('-- ============================================================');
lines.push(`-- STEP 3: Student Records (${TOTAL_STUDENTS} rows in batches of ${BATCH_SIZE})`);
lines.push('-- Section IDs resolved at runtime via subquery (FK-safe)');
lines.push('-- ============================================================');
lines.push('');

const allRows = [];
let seq = 0;

// Compute per-AY student counts
const ayCounts = AY_WEIGHTS.map(w => Math.floor(TOTAL_STUDENTS * w));
ayCounts[ayCounts.length - 1] += TOTAL_STUDENTS - ayCounts.reduce((a, b) => a + b, 0);

for (let ayIdx = 0; ayIdx < ACADEMIC_YEARS.length; ayIdx++) {
  const ay       = ACADEMIC_YEARS[ayIdx];
  const ayCount  = ayCounts[ayIdx];
  const isLatest = ayIdx === ACADEMIC_YEARS.length - 1;

  const campusIds   = shuffle(Array.from({ length: NUM_CAMPUSES }, (_, i) => i + 1));
  const perCampus   = Math.floor(ayCount / NUM_CAMPUSES);
  const extraCampus = ayCount % NUM_CAMPUSES;

  for (let ci = 0; ci < campusIds.length; ci++) {
    const campusId    = campusIds[ci];
    const campusCount = perCampus + (ci < extraCampus ? 1 : 0);
    const allStdIds   = getStandardIds(campusId);       // e.g. [21,22,23,24,25] for campus 5
    const stdIds      = shuffle([...allStdIds]);
    const perStd      = Math.floor(campusCount / stdIds.length);
    const extraStd    = campusCount % stdIds.length;

    for (let si = 0; si < stdIds.length; si++) {
      const stdId    = stdIds[si];
      const stdCount = perStd + (si < extraStd ? 1 : 0);

      // 3 sections: offsets 0, 1, 2
      const secOffsets = [0, 1, 2];
      const perSec     = Math.floor(stdCount / secOffsets.length);
      const extraSec   = stdCount % secOffsets.length;

      // grade offset for age-appropriate DOB (0=grade1 … 4=grade5)
      const gradeOffset = allStdIds.indexOf(stdId);

      for (let ki = 0; ki < secOffsets.length; ki++) {
        const secOffset = secOffsets[ki];
        const secCount  = perSec + (ki < extraSec ? 1 : 0);

        for (let n = 0; n < secCount; n++) {
          const gender    = seededRand() > 0.5 ? 'MALE' : 'FEMALE';
          const firstName = gender === 'MALE' ? pick(MALE_FIRST) : pick(FEMALE_FIRST);
          const lastName  = pick(LAST_NAMES);
          const fullName  = `${firstName} ${lastName}`;
          const code      = `STU-${String(seq).padStart(5,'0')}-${randInt(1000,9999)}`;
          const dob       = randomDob(gradeOffset);
          const enroll    = randomEnrollDate(ay.start);
          const isActive  = isLatest ? 1 : (seededRand() > 0.15 ? 1 : 0);

          allRows.push(
            `  ('${escape(firstName)}', '${escape(lastName)}', '${escape(fullName)}', ` +
            `'${code}', '${dob}', '${gender}', '${enroll}', ` +
            `${isActive}, 0, ` +
            `${campusId}, ${stdId}, ` +
            `${sectionSubquery(stdId, secOffset)}, ` +
            `(SELECT id FROM admission_type LIMIT 1), ` +
            `(SELECT id FROM academic_years WHERE code='${ay.code}' LIMIT 1), ` +
            `1, NOW())`
          );
          seq++;
        }
      }
    }
  }
}

// Shuffle rows for realistic mixed distribution
for (let i = allRows.length - 1; i > 0; i--) {
  const j = Math.floor(seededRand() * (i + 1));
  [allRows[i], allRows[j]] = [allRows[j], allRows[i]];
}

const INSERT_HEADER =
  'INSERT INTO students\n' +
  '  (first_name, last_name, full_name, student_code, date_of_birth, gender,\n' +
  '   enrollment_date, is_active, deleted, campus_id, standard_id, section_id,\n' +
  '   admission_type_id, academic_year_id, organization_id, created_at)\nVALUES';

let batchNum = 1;
for (let i = 0; i < allRows.length; i += BATCH_SIZE) {
  const batch = allRows.slice(i, i + BATCH_SIZE);
  lines.push(`-- Batch ${batchNum} (rows ${i + 1}–${i + batch.length})`);
  lines.push(INSERT_HEADER);
  lines.push(batch.join(',\n') + ';');
  lines.push('');
  batchNum++;
}

// ── Write output ───────────────────────────────────────────────────────────────
const outPath = path.join(
  __dirname,
  '..', 'src', 'main', 'resources', 'db', 'populate_dashboard_large.sql'
);
fs.writeFileSync(outPath, lines.join('\n'), 'utf8');

const stats = fs.statSync(outPath);
console.log('✅ Done!');
console.log(`   File    : ${outPath}`);
console.log(`   Size    : ${(stats.size / 1024 / 1024).toFixed(2)} MB`);
console.log(`   Students: ${allRows.length}`);
console.log(`   Batches : ${batchNum - 1}`);
console.log(`   Sections added for standards 11-50: ${(LAST_STANDARD - FIRST_MISSING_STANDARD + 1) * 3} rows`);
console.log(`   AY dist : ${ayCounts.map((c,i) => `${ACADEMIC_YEARS[i].code}=${c}`).join(' | ')}`);
