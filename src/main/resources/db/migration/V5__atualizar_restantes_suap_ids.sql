-- V5__atualizar_restantes_suap_ids.sql

-- ==============================================================================
-- 1. SANEAMENTO DE DADOS (UPDATE)
-- Preenche colunas NULL garantindo a unicidade atraves da concatenacao
-- ==============================================================================

UPDATE academico.disciplina
SET codigo_suap = 'DISC-' || id
WHERE codigo_suap IS NULL;

UPDATE academico.usuario
SET suap_id = 'USR-' || id
WHERE suap_id IS NULL;

UPDATE academico.aluno
SET suap_id = 'SUAP-ALU-' || id
WHERE suap_id IS NULL;

UPDATE academico.professor
SET suap_id = 'SUAP-PROF-' || id
WHERE suap_id IS NULL;

UPDATE academico.turma
SET codigo_suap = 'TURMA-' || id
WHERE codigo_suap IS NULL;

UPDATE academico.nota
SET codigo_suap = 'NOTA-' || id
WHERE codigo_suap IS NULL;

UPDATE academico.falta
SET codigo_suap = 'FALTA-' || id
WHERE codigo_suap IS NULL;

-- ==============================================================================
-- 2. APLICAÇÃO DAS RESTRIÇÕES (ALTER TABLE)
-- Aplica a obrigatoriedade (NOT NULL) e unicidade (UNIQUE)
-- ==============================================================================

ALTER TABLE academico.disciplina
    ALTER COLUMN codigo_suap SET NOT NULL,
    ADD CONSTRAINT uk_disciplina_codigo_suap UNIQUE (codigo_suap);

ALTER TABLE academico.usuario
    ALTER COLUMN suap_id SET NOT NULL,
    ADD CONSTRAINT uk_usuario_suap_id UNIQUE (suap_id);

ALTER TABLE academico.aluno
    ALTER COLUMN suap_id SET NOT NULL,
    ADD CONSTRAINT uk_aluno_suap_id UNIQUE (suap_id);

ALTER TABLE academico.professor
    ALTER COLUMN suap_id SET NOT NULL,
    ADD CONSTRAINT uk_professor_suap_id UNIQUE (suap_id);

ALTER TABLE academico.turma
    ALTER COLUMN codigo_suap SET NOT NULL,
    ADD CONSTRAINT uk_turma_codigo_suap UNIQUE (codigo_suap);

ALTER TABLE academico.nota
    ALTER COLUMN codigo_suap SET NOT NULL,
    ADD CONSTRAINT uk_nota_codigo_suap UNIQUE (codigo_suap);

ALTER TABLE academico.falta
    ALTER COLUMN codigo_suap SET NOT NULL,
    ADD CONSTRAINT uk_falta_codigo_suap UNIQUE (codigo_suap);
