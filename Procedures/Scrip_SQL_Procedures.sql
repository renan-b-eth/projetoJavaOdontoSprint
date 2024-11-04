-- Procedure para inserir paciente
CREATE OR REPLACE PROCEDURE inserir_paciente (
    p_nome VARCHAR2,
    p_data_nascimento DATE,
    p_sexo VARCHAR2,
    p_cpf VARCHAR2,
    p_email VARCHAR2,
    p_telefone VARCHAR2,
    p_id_endereco NUMERIC
) IS
BEGIN
    IF validar_cpf(p_cpf) AND validar_email(p_email) THEN
        INSERT INTO ODONTO_PACIENTE (
            NOME_PACIENTE, DATA_NASCIMENTO_PACIENTE, SEXO_PACIENTE, CPF_PACIENTE, EMAIL_PACIENTE, TELEFONE_PACIENTE, ID_ENDERECO
        ) VALUES (
            p_nome, p_data_nascimento, p_sexo, p_cpf, p_email, p_telefone, p_id_endereco
        );
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Dados de entrada inválidos.');
    END IF;
END inserir_paciente;


-- Procedure para atualizar paciente
CREATE OR REPLACE PROCEDURE atualizar_paciente (
    p_id_paciente NUMERIC,
    p_nome VARCHAR2,
    p_data_nascimento DATE,
    p_sexo VARCHAR2,
    p_cpf VARCHAR2,
    p_email VARCHAR2,
    p_telefone VARCHAR2,
    p_id_endereco NUMERIC
) IS
BEGIN
    IF validar_cpf(p_cpf) AND validar_email(p_email) THEN
        UPDATE ODONTO_PACIENTE SET
            NOME_PACIENTE = p_nome,
            DATA_NASCIMENTO_PACIENTE = p_data_nascimento,
            SEXO_PACIENTE = p_sexo,
            CPF_PACIENTE = p_cpf,
            EMAIL_PACIENTE = p_email,
            TELEFONE_PACIENTE = p_telefone,
            ID_ENDERECO = p_id_endereco
        WHERE ID_PACIENTE = p_id_paciente;
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Dados de entrada inválidos.');
    END IF;
END atualizar_paciente;


-- Procedure para deletar paciente
CREATE OR REPLACE PROCEDURE deletar_paciente (
    p_id_paciente NUMERIC
) IS
BEGIN
    DELETE FROM ODONTO_PACIENTE WHERE ID_PACIENTE = p_id_paciente;
END deletar_paciente;