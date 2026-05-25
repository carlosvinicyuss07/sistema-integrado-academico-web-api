-- V4__atualizar_e_blindar_codigos_suap.sql

-- ==============================================================================
-- 1. SANEAMENTO DE DADOS (UPDATE)
-- Preenche colunas NULL garantindo a unicidade atraves da concatenacao do ID
-- ==============================================================================

UPDATE academico.curso
SET codigo_suap = 'CURSO-' || id
WHERE codigo_suap IS NULL;

UPDATE academico.aluno
SET matricula = 'MAT-A-' || id
WHERE matricula IS NULL;

UPDATE academico.professor
SET matricula_siape = 'MAT-P-' || id
WHERE matricula_siape IS NULL;

-- ==============================================================================
-- 2. APLICAÇÃO DAS RESTRIÇÕES (ALTER TABLE)
-- Aplica a obrigatoriedade (NOT NULL) e unicidade (UNIQUE)
-- ==============================================================================

ALTER TABLE academico.curso
    ALTER COLUMN codigo_suap SET NOT NULL,
    ADD CONSTRAINT uk_curso_codigo_suap UNIQUE (codigo_suap);

ALTER TABLE academico.aluno
    ALTER COLUMN matricula SET NOT NULL,
    ADD CONSTRAINT uk_aluno_matricula UNIQUE (matricula);

ALTER TABLE academico.professor
    ALTER COLUMN matricula_siape SET NOT NULL,
    ADD CONSTRAINT uk_professor_matricula_siape UNIQUE (matricula_siape);
