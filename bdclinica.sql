create database bdclinica
use bdclinica
go
create table especialidade
(
	IdEsp int not null,
	NomeEsp varchar(100) not null 
	primary key (IdEsp)
)

create table medico
(
	IdMed int not null,
	CRM int not null unique,
	NomeMed varchar(100) not null,
	EnderecoMed varchar(150) not null,
	NumMed char(4) not null,
	CEP char(8) not null,
	Celular char(11) not null,
	IdEspec int not null 
	primary key(IdMed)
	foreign key (IdEspec) references especialidade(IdEsp)
)

create table paciente
(
	IdPac int not null,
	NomePac varchar(100),
	CPF char(11) not null unique,
	EnderecoPac varchar(150) not null,
	NumPac char(4) not null,
	Celular char(11) not null,
	sexo char(1) not null,
	email varchar(100) not null
	primary key (IdPac) 
	
)

create table consulta
(
	IdCon int not null,
	DataCon datetime not null unique,
	IdPac int not null,
	IdMed int not null
	primary key(IdCon)
	foreign key(IdPac) references paciente(IdPac),
	foreign key(IdMed) references medico(IdMed)
)

create procedure sp_crudpaciente(@cod char(1), @IdPac int, @NomePac varchar(100),
					@CPF char(11), @EnderecoPac varchar(150), @NumPac char(4), 
					@Celular char(11), @sexo char(1), @email varchar(100),
					@saida varchar(max) output)
as
	if(UPPER (@cod) = 'I' or UPPER (@cod) = 'D' or UPPER(@cod) = 'U')
	begin
		if(upper(@cod) = 'I')
		BEGIN
			insert into paciente(NomePac, CPF, EnderecoPac, NumPac, Celular, sexo, email)
			values(@NomePac, @CPF, @EnderecoPac, @NumPac, @Celular, @sexo, @email)
			
			set @saida = 'Inserido com sucesso'
		end
		
		if(upper(@cod) = 'U')
		BEGIN
			update paciente
			set NomePac = @NomePac, CPF = @CPF, EnderecoPac = @EnderecoPac, NumPac = @NumPac,
				Celular = @Celular, sexo = @sexo, email = @email
			where IdPac = @IdPac
			
			set @saida = 'Atualizado com sucesso'
		end
		
		if(upper(@cod) = 'D')
		BEGIN
			delete paciente
			where IdPac = @IdPac
			set @saida = 'Excluido com sucesso'
		end
		
	end
	ELSE
	BEGIN
		raiserror('Operacao invalida', 16, 1)
	end

	select * from paciente 

	declare @out varchar(max)
	exec sp_crudpaciente 'i', 1, 'Fulano', '12345678909', 'Rua C',
		'1', '11987654321', 'm', 'fulano@fulano.com', @out output
	print @out
	
	declare @out varchar(max)
	exec sp_crudpaciente 'i', 2, 'Cicrano', '98706543212', 'Rua dos Bobos',
		'2', '11912345678', 'm', 'Cicrano@Cicrano.com', @out output
	print @out

	declare @out varchar(max)
	exec sp_crudpaciente 'u', 2, 'Cicraninho', '98706543212', 'Rua dos Bobos',
		'2', '11912345678', 'm', 'Cicrano@Cicrano.com', @out output
	print @out

	declare @out varchar(max)
	exec sp_crudpaciente 'd', 2, 'Cicraninho', '98706543212', 'Rua dos Bobos',
		'2', '11912345678', 'm', 'Cicrano@Cicrano.com', @out output
	print @out