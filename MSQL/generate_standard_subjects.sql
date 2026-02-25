SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE standard_subjects;
SET FOREIGN_KEY_CHECKS = 1;

-- ==========================================
-- Downtown Campus
-- ==========================================
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Uptown Campus
-- ==========================================
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Riverside Campus
-- ==========================================
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Hilltop Campus
-- ==========================================
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Greenfield Campus
-- ==========================================
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Seaside Campus
-- ==========================================
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Central Campus
-- ==========================================
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Lakeside Campus
-- ==========================================
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Sunrise Campus
-- ==========================================
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Maple Campus
-- ==========================================
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1, 
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1, 
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1, 
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1, 
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1, 
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT 
    1, 
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1, 
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

