USE [hackchallenge]
GO
/****** Object:  Table [dbo].[Beneficiario]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Beneficiario](
	[idBeneficiario] [int] IDENTITY(1,1) NOT NULL,
	[idCliente] [int] NULL,
	[nombre] [varchar](50) NULL,
	[apPaterno] [varchar](50) NULL,
	[apMaterno] [varchar](50) NULL,
	[fechaNacimiento] [varchar](30) NULL,
	[estatus] [varchar](50) NULL,
 CONSTRAINT [PK_Beneficiario] PRIMARY KEY CLUSTERED 
(
	[idBeneficiario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cliente](
	[idCliente] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[apPaterno] [varchar](50) NOT NULL,
	[apMaterno] [varchar](50) NOT NULL,
	[fechaNacimiento] [varchar](30) NOT NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cuenta]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cuenta](
	[idCuenta] [int] NOT NULL,
	[idCliente] [int] NOT NULL,
	[cuenta] [varchar](50) NOT NULL,
	[saldo] [int] NULL,
 CONSTRAINT [PK_Cuenta] PRIMARY KEY CLUSTERED 
(
	[idCuenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Operaciones]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Operaciones](
	[idOperaciones] [int] IDENTITY(1,1) NOT NULL,
	[idCuenta] [int] NULL,
	[referencia] [varchar](50) NULL,
	[monto] [int] NULL,
	[cuenta] [varchar](50) NULL,
	[descripcion] [varchar](50) NULL,
	[fecha] [varchar](50) NULL,
 CONSTRAINT [PK_Operaciones] PRIMARY KEY CLUSTERED 
(
	[idOperaciones] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Perfil]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Perfil](
	[idUsuario] [int] NOT NULL,
	[password] [varchar](50) NOT NULL,
	[idCliente] [int] NOT NULL,
 CONSTRAINT [PK_Perfil] PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TiposOperaciones]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TiposOperaciones](
	[idTiOperaciones] [int] IDENTITY(1,1) NOT NULL,
	[idOperaciones] [int] NULL,
	[descripcion] [varchar](50) NULL,
 CONSTRAINT [PK_TiposOperaciones] PRIMARY KEY CLUSTERED 
(
	[idTiOperaciones] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Perfil]  WITH CHECK ADD  CONSTRAINT [FK_Perfil_Perfil] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[Perfil] ([idUsuario])
GO
ALTER TABLE [dbo].[Perfil] CHECK CONSTRAINT [FK_Perfil_Perfil]
GO
/****** Object:  StoredProcedure [dbo].[SP_ConsultaBeneficiarioXCliente]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_ConsultaBeneficiarioXCliente](
@idCliente int
)
as

select beneficiario.nombre, beneficiario.apPaterno, beneficiario.apMaterno from beneficiario
INNER JOIN cliente
ON cliente.idCliente = beneficiario.idCliente
where cliente.idCliente = @idCliente


GO
/****** Object:  StoredProcedure [dbo].[SP_ConsultaCliente]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_ConsultaCliente](
@idcliente int
)
as 
select nombre,apPaterno,apMaterno,fechaNacimiento from Cliente where idCliente = @idcliente 



GO
/****** Object:  StoredProcedure [dbo].[SP_ConsultaCuentaXCliente]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_ConsultaCuentaXCliente](
@idCliente int

)
as 

SELECT cuenta.saldo, cuenta.cuenta
FROM Cuenta
INNER JOIN Cliente
ON cuenta.idCliente = cliente.idCliente
where cliente.idCliente = @idCliente
GO
/****** Object:  StoredProcedure [dbo].[SP_EliminarCliente]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_EliminarCliente](
@idcliente int
)
as 
delete from Cliente where idCliente = @idcliente 



GO
/****** Object:  StoredProcedure [dbo].[SP_InsertarBeneficiario]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_InsertarBeneficiario](
@nombre varchar(50),
@apPaterno varchar (50),
@apMaterno varchar (50),
@fechaNacimiento varchar(30),
@Estatus varchar (50)


)
as 

insert into Beneficiario(nombre,apPaterno,apMaterno,fechaNacimiento,estatus) 
values (@nombre,@apPaterno,@apMaterno,@fechaNacimiento,@Estatus);
GO
/****** Object:  StoredProcedure [dbo].[SP_InsertarCliente]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_InsertarCliente] (
@Nombre varchar (50),
@apPaterno varchar (50),
@apMaterno varchar(50),
@fechaNacimiento varchar (30)
 )

as
insert into Cliente (Nombre,apPaterno,apMaterno,fechaNacimiento) 
values (@Nombre,@apPaterno,@apMaterno,@fechaNacimiento)

GO
/****** Object:  StoredProcedure [dbo].[SP_InsertarCuenta]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_InsertarCuenta](

@cuenta varchar (50),
@saldo int
)
as 
insert into Cuenta (cuenta,saldo) values (@cuenta,@saldo);

GO
/****** Object:  StoredProcedure [dbo].[SP_InsertarPerfil]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE procedure [dbo].[SP_InsertarPerfil] (

@idPerfil int,
@password varchar (50),
@idCliente int 
 )

as


insert into Perfil (idCliente,password,idUsuario) 
values (@idCliente,@password,@idCliente)



GO
/****** Object:  StoredProcedure [dbo].[SP_InsertarTipoOperacion]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_InsertarTipoOperacion](
@Descripcion varchar (50)

)
as 

insert into TiposOperaciones (descripcion) values (@Descripcion);
GO
/****** Object:  StoredProcedure [dbo].[SP_ModificarCliente]    Script Date: 25/08/2019 09:24:11 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_ModificarCliente](
@idcliente int,
@nombreCliente varchar (50),
@apPaterno varchar (50),
@apMaterno varchar (50),
@fecha varchar(30)
)
as 

Update Cliente 
Set Nombre = @nombreCliente,
    apPaterno = @apPaterno,
	apMaterno = @apMaterno,
	fechaNacimiento = @fecha
Where idCliente =@idcliente
GO
