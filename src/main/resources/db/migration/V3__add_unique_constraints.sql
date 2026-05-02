-- Adição de Restrições de Unicidade (Constraints UNIQUE)

ALTER TABLE academico.usuario
    ADD CONSTRAINT usuario_suap_id_uk UNIQUE (suap_id);

ALTER TABLE academico.curso
    ADD CONSTRAINT curso_codigo_suap_uk UNIQUE (codigo_suap);

ALTER TABLE academico.disciplina
    ADD CONSTRAINT disciplina_codigo_uk UNIQUE (codigo);

ALTER TABLE academico.disciplina
    ADD CONSTRAINT disciplina_codigo_suap_uk UNIQUE (codigo_suap);

ALTER TABLE academico.turma
    ADD CONSTRAINT turma_codigo_suap_uk UNIQUE (codigo_suap);

ALTER TABLE academico.professor
    ADD CONSTRAINT professor_matricula_siape_uk UNIQUE (matricula_siape);

ALTER TABLE academico.professor
    ADD CONSTRAINT professor_suap_id_uk UNIQUE (suap_id);

ALTER TABLE academico.aluno
    ADD CONSTRAINT aluno_suap_id_uk UNIQUE (suap_id);

ALTER TABLE academico.nota
    ADD CONSTRAINT nota_codigo_suap_uk UNIQUE (codigo_suap);

ALTER TABLE academico.falta
    ADD CONSTRAINT falta_codigo_suap_uk UNIQUE (codigo_suap);