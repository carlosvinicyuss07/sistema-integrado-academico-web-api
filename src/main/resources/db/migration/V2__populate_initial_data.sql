-- Povoamento Inicial de Dados (Mock Data)

-- 1. Períodos Letivos
INSERT INTO academico.periodo_letivo (ano, semestre, descricao) VALUES
(2024, 1, '2024.1'),
(2024, 2, '2024.2');

-- 2. Cursos
INSERT INTO academico.curso (nome, codigo_suap) VALUES
('Análise e Desenvolvimento de Sistemas', 'ADS01'),
('Administração', 'ADM01'),
('Redes de Computadores', 'RED01');

-- 3. Disciplinas
INSERT INTO academico.disciplina (nome, codigo, carga_horaria) VALUES
('Lógica de Programação', 'LOG101', 60),
('Banco de Dados', 'BD101', 60),
('Gestão de Pessoas', 'GP101', 40),
('Infraestrutura de Redes', 'RED101', 80);

-- 4. Usuários (Total: 34 -> 1 Admin, 3 Profs, 30 Alunos)
INSERT INTO academico.usuario (nome, email, login, senha, perfil) VALUES
-- Admin (ID 1)
('João Batista Peixoto', 'joao.admin@instituicao.edu', 'joao.admin', 'senha123', 'ADMIN'),
-- Professores (IDs 2 a 4)
('Carlos Eduardo Souza', 'carlos.souza@instituicao.edu', 'carlos.souza', 'senha123', 'PROFESSOR'),
('Ana Beatriz Rocha', 'ana.rocha@instituicao.edu', 'ana.rocha', 'senha123', 'PROFESSOR'),
('Roberto Alves Dias', 'roberto.dias@instituicao.edu', 'roberto.dias', 'senha123', 'PROFESSOR'),
-- Alunos ADS (IDs 5 a 14)
('Lucas Oliveira Mendes', 'lucas.mendes@aluno.edu', 'lucas.mendes', 'senha123', 'ALUNO'),
('Mariana Costa e Silva', 'mariana.costa@aluno.edu', 'mariana.costa', 'senha123', 'ALUNO'),
('Felipe Rodrigues', 'felipe.rodrigues@aluno.edu', 'felipe.rodrigues', 'senha123', 'ALUNO'),
('Juliana Martins', 'juliana.martins@aluno.edu', 'juliana.martins', 'senha123', 'ALUNO'),
('Thiago Pereira', 'thiago.pereira@aluno.edu', 'thiago.pereira', 'senha123', 'ALUNO'),
('Beatriz Ferreira', 'beatriz.ferreira@aluno.edu', 'beatriz.ferreira', 'senha123', 'ALUNO'),
('Rafael Gomes', 'rafael.gomes@aluno.edu', 'rafael.gomes', 'senha123', 'ALUNO'),
('Camila Alves', 'camila.alves@aluno.edu', 'camila.alves', 'senha123', 'ALUNO'),
('Bruno Henrique Santos', 'bruno.santos@aluno.edu', 'bruno.santos', 'senha123', 'ALUNO'),
('Amanda Lima', 'amanda.lima@aluno.edu', 'amanda.lima', 'senha123', 'ALUNO'),
-- Alunos ADM (IDs 15 a 24)
('Gabriel Fernandes', 'gabriel.fernandes@aluno.edu', 'gabriel.fernandes', 'senha123', 'ALUNO'),
('Larissa Ribeiro', 'larissa.ribeiro@aluno.edu', 'larissa.ribeiro', 'senha123', 'ALUNO'),
('Pedro Henrique Carvalho', 'pedro.carvalho@aluno.edu', 'pedro.carvalho', 'senha123', 'ALUNO'),
('Fernanda Castro', 'fernanda.castro@aluno.edu', 'fernanda.castro', 'senha123', 'ALUNO'),
('Matheus Araújo', 'matheus.araujo@aluno.edu', 'matheus.araujo', 'senha123', 'ALUNO'),
('Letícia Barbosa', 'leticia.barbosa@aluno.edu', 'leticia.barbosa', 'senha123', 'ALUNO'),
('Leonardo Monteiro', 'leonardo.monteiro@aluno.edu', 'leonardo.monteiro', 'senha123', 'ALUNO'),
('Vanessa Teixeira', 'vanessa.teixeira@aluno.edu', 'vanessa.teixeira', 'senha123', 'ALUNO'),
('Diego Correia', 'diego.correia@aluno.edu', 'diego.correia', 'senha123', 'ALUNO'),
('Patrícia Rocha', 'patricia.rocha@aluno.edu', 'patricia.rocha', 'senha123', 'ALUNO'),
-- Alunos REDES (IDs 25 a 34)
('Rodrigo Azevedo', 'rodrigo.azevedo@aluno.edu', 'rodrigo.azevedo', 'senha123', 'ALUNO'),
('Isabela Cardoso', 'isabela.cardoso@aluno.edu', 'isabela.cardoso', 'senha123', 'ALUNO'),
('Marcelo Vieira', 'marcelo.vieira@aluno.edu', 'marcelo.vieira', 'senha123', 'ALUNO'),
('Carolina Pires', 'carolina.pires@aluno.edu', 'carolina.pires', 'senha123', 'ALUNO'),
('André Nunes', 'andre.nunes@aluno.edu', 'andre.nunes', 'senha123', 'ALUNO'),
('Natália Freitas', 'natalia.freitas@aluno.edu', 'natalia.freitas', 'senha123', 'ALUNO'),
('Gustavo Moura', 'gustavo.moura@aluno.edu', 'gustavo.moura', 'senha123', 'ALUNO'),
('Tatiane Moraes', 'tatiane.moraes@aluno.edu', 'tatiane.moraes', 'senha123', 'ALUNO'),
('Renato Cavalcanti', 'renato.cavalcanti@aluno.edu', 'renato.cavalcanti', 'senha123', 'ALUNO'),
('Aline Farias', 'aline.farias@aluno.edu', 'aline.farias', 'senha123', 'ALUNO');

-- 5. Professores (Relaciona com IDs de Usuário 2, 3 e 4)
INSERT INTO academico.professor (usuario_id, matricula_siape) VALUES
(2, 'SIAPE001'), (3, 'SIAPE002'), (4, 'SIAPE003');

-- 6. Alunos (Relaciona Usuários aos Cursos)
INSERT INTO academico.aluno (usuario_id, curso_id, matricula) VALUES
-- 10 Alunos em Análise de Sistemas (Curso 1)
(5, 1, 'ADS2024001'), (6, 1, 'ADS2024002'), (7, 1, 'ADS2024003'), (8, 1, 'ADS2024004'), (9, 1, 'ADS2024005'),
(10, 1, 'ADS2024006'), (11, 1, 'ADS2024007'), (12, 1, 'ADS2024008'), (13, 1, 'ADS2024009'), (14, 1, 'ADS2024010'),
-- 10 Alunos em Administração (Curso 2)
(15, 2, 'ADM2024001'), (16, 2, 'ADM2024002'), (17, 2, 'ADM2024003'), (18, 2, 'ADM2024004'), (19, 2, 'ADM2024005'),
(20, 2, 'ADM2024006'), (21, 2, 'ADM2024007'), (22, 2, 'ADM2024008'), (23, 2, 'ADM2024009'), (24, 2, 'ADM2024010'),
-- 10 Alunos em Redes (Curso 3)
(25, 3, 'RED2024001'), (26, 3, 'RED2024002'), (27, 3, 'RED2024003'), (28, 3, 'RED2024004'), (29, 3, 'RED2024005'),
(30, 3, 'RED2024006'), (31, 3, 'RED2024007'), (32, 3, 'RED2024008'), (33, 3, 'RED2024009'), (34, 3, 'RED2024010');

-- 7. Turmas (Período 1)
INSERT INTO academico.turma (disciplina_id, professor_id, periodo_letivo_id, descricao) VALUES
(1, 1, 1, 'Lógica de Programação - Turma A'), -- Prof Carlos
(2, 1, 1, 'Banco de Dados - Turma A'), -- Prof Carlos
(3, 2, 1, 'Gestão de Pessoas - Turma A'), -- Profa Ana
(4, 3, 1, 'Infraestrutura de Redes - Turma A'); -- Prof Roberto

-- 8. Matrículas nas Turmas
INSERT INTO academico.matricula_turma (aluno_id, turma_id, situacao, data_matricula) VALUES
-- Matriculando os 5 primeiros alunos de ADS em Lógica (Turma 1) e BD (Turma 2)
(1, 1, 'CURSANDO', CURRENT_DATE), (1, 2, 'CURSANDO', CURRENT_DATE),
(2, 1, 'CURSANDO', CURRENT_DATE), (2, 2, 'CURSANDO', CURRENT_DATE),
(3, 1, 'CURSANDO', CURRENT_DATE), (3, 2, 'CURSANDO', CURRENT_DATE),
(4, 1, 'CURSANDO', CURRENT_DATE), (4, 2, 'CURSANDO', CURRENT_DATE),
(5, 1, 'CURSANDO', CURRENT_DATE), (5, 2, 'CURSANDO', CURRENT_DATE),
-- Matriculando 5 alunos de ADM em Gestão (Turma 3)
(11, 3, 'CURSANDO', CURRENT_DATE), (12, 3, 'CURSANDO', CURRENT_DATE),
(13, 3, 'CURSANDO', CURRENT_DATE), (14, 3, 'CURSANDO', CURRENT_DATE),
(15, 3, 'CURSANDO', CURRENT_DATE),
-- Matriculando 5 alunos de Redes em Infraestrutura (Turma 4)
(21, 4, 'CURSANDO', CURRENT_DATE), (22, 4, 'CURSANDO', CURRENT_DATE),
(23, 4, 'CURSANDO', CURRENT_DATE), (24, 4, 'CURSANDO', CURRENT_DATE),
(25, 4, 'CURSANDO', CURRENT_DATE);

-- 9. Notas e Faltas (Amostragem para testes na API)
-- Lançando notas para a matricula_turma 1 (Lucas em Lógica)
INSERT INTO academico.nota (matricula_turma_id, descricao, valor, peso, data_avaliacao) VALUES
(1, 'Primeira Prova', 8.5, 1.0, CURRENT_DATE),
(1, 'Trabalho Prático', 9.0, 1.0, CURRENT_DATE);

INSERT INTO academico.falta (matricula_turma_id, data_aula, quantidade) VALUES
(1, CURRENT_DATE - INTERVAL '5 days', 2);

-- Lançando notas para a matricula_turma 3 (Mariana em Lógica)
INSERT INTO academico.nota (matricula_turma_id, descricao, valor, peso, data_avaliacao) VALUES
(3, 'Primeira Prova', 5.5, 1.0, CURRENT_DATE);

-- 10. Chat das Turmas (Salas vazias prontas para receber mensagens via POST)
INSERT INTO academico.chat_turma (turma_id, titulo) VALUES
(1, 'Chat - Lógica de Programação (Turma A)'),
(2, 'Chat - Banco de Dados (Turma A)'),
(3, 'Chat - Gestão de Pessoas (Turma A)'),
(4, 'Chat - Infraestrutura de Redes (Turma A)');
