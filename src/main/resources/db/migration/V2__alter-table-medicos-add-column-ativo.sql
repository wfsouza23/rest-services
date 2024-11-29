ALTER TABLE medicos ADD ativo tinyint;
ALTER TABLE medicos SET ativo = 1;
ALTER TABLE medicos MODIFY ativo TINYINT NOT NULL DEFAULT 1;