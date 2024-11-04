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


CREATE OR REPLACE PROCEDURE inserir_consultorio (
    p_nome_clinica VARCHAR2,
    p_tipo_atendimento VARCHAR2,
    p_id_endereco NUMERIC
) IS
BEGIN
    -- Validações
    IF LENGTH(p_nome_clinica) = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'O nome da clínica é obrigatório.');
    END IF;

    INSERT INTO ODONTO_CLINICA (
        NOME_CLINICA, TIPO_ATENDIMENTO, ID_ENDERECO
    ) VALUES (
        p_nome_clinica, p_tipo_atendimento, p_id_endereco
    );
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20002, 'Erro ao inserir consultório: ' || SQLERRM);
END inserir_consultorio;

CREATE OR REPLACE PROCEDURE atualizar_consultorio (
    p_id_clinica NUMERIC,
    p_nome_clinica VARCHAR2,
    p_tipo_atendimento VARCHAR2,
    p_id_endereco NUMERIC
) IS
BEGIN
    UPDATE ODONTO_CLINICA
    SET
        NOME_CLINICA = p_nome_clinica,
        TIPO_ATENDIMENTO = p_tipo_atendimento,
        ID_ENDERECO = p_id_endereco
    WHERE ID_CLINICA = p_id_clinica;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20006, 'Consultório não encontrado.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20007, 'Erro ao atualizar consultório: ' || SQLERRM);
END atualizar_consultorio;

CREATE OR REPLACE FUNCTION validar_consultorio (
    p_nome_clinica VARCHAR2,
    p_tipo_atendimento VARCHAR2,
    p_id_endereco NUMERIC
) RETURN BOOLEAN IS
    v_count NUMBER;
BEGIN
    -- Verifica se já existe um consultório com o mesmo nome e endereço
    SELECT COUNT(*) INTO v_count
    FROM ODONTO_CLINICA
    WHERE NOME_CLINICA = p_nome_clinica
    AND ID_ENDERECO = p_id_endereco;
    
    IF v_count > 0 THEN
        RETURN FALSE;
    END IF;
    
    RETURN TRUE;
END validar_consultorio;

-- Executar

SQL> EXECUTE inserir_consultorio('Clínica Sorriso', 'Odontologia Geral', 123);

SQL> EXECUTE atualizar_consultorio(1, 'Clínica Sorriso Renovada', 'Odontologia Estética', 456);

