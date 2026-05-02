CREATE SCHEMA IF NOT EXISTS academico;

CREATE TABLE academico.usuario (
    id bigserial NOT NULL,
    nome varchar(150) NOT NULL,
    email varchar(150) NOT NULL,
    login varchar(100) NOT NULL,
    senha varchar(255),
    perfil varchar(30) NOT NULL,
    suap_id varchar(100),
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    data_cadastro timestamp DEFAULT now() NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (id),
    CONSTRAINT usuario_email_uk UNIQUE (email),
    CONSTRAINT usuario_login_uk UNIQUE (login)
);

CREATE TABLE academico.periodo_letivo (
    id bigserial NOT NULL,
    ano integer NOT NULL,
    semestre integer NOT NULL,
    descricao varchar(50) NOT NULL,
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT periodo_letivo_pk PRIMARY KEY (id),
    CONSTRAINT periodo_letivo_uk UNIQUE (ano, semestre)
);

CREATE TABLE academico.curso (
    id bigserial NOT NULL,
    nome varchar(150) NOT NULL,
    codigo_suap varchar(100),
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT curso_pk PRIMARY KEY (id)
);

CREATE TABLE academico.aluno (
    id bigserial NOT NULL,
    usuario_id bigint NOT NULL,
    curso_id bigint,
    matricula varchar(50) NOT NULL,
    suap_id varchar(100),
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT aluno_pk PRIMARY KEY (id),
    CONSTRAINT aluno_matricula_uk UNIQUE (matricula),
    CONSTRAINT aluno_usuario_fk FOREIGN KEY (usuario_id) REFERENCES academico.usuario(id),
    CONSTRAINT aluno_curso_fk FOREIGN KEY (curso_id) REFERENCES academico.curso(id)
);

CREATE TABLE academico.professor (
    id bigserial NOT NULL,
    usuario_id bigint NOT NULL,
    matricula_siape varchar(50),
    suap_id varchar(100),
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT professor_pk PRIMARY KEY (id),
    CONSTRAINT professor_usuario_fk FOREIGN KEY (usuario_id) REFERENCES academico.usuario(id)
);

CREATE TABLE academico.disciplina (
    id bigserial NOT NULL,
    nome varchar(150) NOT NULL,
    codigo varchar(50),
    codigo_suap varchar(100),
    carga_horaria integer,
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT disciplina_pk PRIMARY KEY (id)
);

CREATE TABLE academico.turma (
    id bigserial NOT NULL,
    disciplina_id bigint NOT NULL,
    professor_id bigint,
    periodo_letivo_id bigint NOT NULL,
    descricao varchar(150) NOT NULL,
    codigo_suap varchar(100),
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT turma_pk PRIMARY KEY (id),
    CONSTRAINT turma_disciplina_fk FOREIGN KEY (disciplina_id) REFERENCES academico.disciplina(id),
    CONSTRAINT turma_professor_fk FOREIGN KEY (professor_id) REFERENCES academico.professor(id),
    CONSTRAINT turma_periodo_fk FOREIGN KEY (periodo_letivo_id) REFERENCES academico.periodo_letivo(id)
);

CREATE TABLE academico.matricula_turma (
    id bigserial NOT NULL,
    aluno_id bigint NOT NULL,
    turma_id bigint NOT NULL,
    situacao varchar(50),
    data_matricula date,
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT matricula_turma_pk PRIMARY KEY (id),
    CONSTRAINT matricula_aluno_turma_uk UNIQUE (aluno_id, turma_id),
    CONSTRAINT matricula_aluno_fk FOREIGN KEY (aluno_id) REFERENCES academico.aluno(id),
    CONSTRAINT matricula_turma_fk FOREIGN KEY (turma_id) REFERENCES academico.turma(id)
);

CREATE TABLE academico.nota (
    id bigserial NOT NULL,
    matricula_turma_id bigint NOT NULL,
    descricao varchar(100) NOT NULL,
    valor numeric(5,2),
    peso numeric(5,2),
    data_avaliacao date,
    codigo_suap varchar(100),
    CONSTRAINT nota_pk PRIMARY KEY (id),
    CONSTRAINT nota_matricula_fk FOREIGN KEY (matricula_turma_id) REFERENCES academico.matricula_turma(id)
);

CREATE TABLE academico.falta (
    id bigserial NOT NULL,
    matricula_turma_id bigint NOT NULL,
    data_aula date NOT NULL,
    quantidade integer DEFAULT 1 NOT NULL,
    justificativa text,
    codigo_suap varchar(100),
    CONSTRAINT falta_pk PRIMARY KEY (id),
    CONSTRAINT falta_matricula_fk FOREIGN KEY (matricula_turma_id) REFERENCES academico.matricula_turma(id)
);

CREATE TABLE academico.chat_turma (
    id bigserial NOT NULL,
    turma_id bigint NOT NULL,
    titulo varchar(150),
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    criacao timestamp DEFAULT now() NOT NULL,
    CONSTRAINT chat_turma_pk PRIMARY KEY (id),
    CONSTRAINT chat_turma_turma_fk FOREIGN KEY (turma_id) REFERENCES academico.turma(id)
);

CREATE TABLE academico.chat_mensagem (
    id bigserial NOT NULL,
    chat_turma_id bigint NOT NULL,
    usuario_id bigint NOT NULL,
    conteudo text NOT NULL,
    data_envio timestamp DEFAULT now() NOT NULL,
    status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT chat_mensagem_pk PRIMARY KEY (id),
    CONSTRAINT chat_mensagem_chat_fk FOREIGN KEY (chat_turma_id) REFERENCES academico.chat_turma(id),
    CONSTRAINT chat_mensagem_usuario_fk FOREIGN KEY (usuario_id) REFERENCES academico.usuario(id)
);