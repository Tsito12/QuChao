create role admin_apuestas
nosuperuser
nocreatedb
nocreaterole
inherit;

grant usage on schema scautodromo to admin_apuestas;

grant select on table scautodromo.apuesta to admin_apuestas;
grant select on table scautodromo.resultados to admin_apuestas;
grant select on table scautodromo.cliente to admin_apuestas;
grant select on table scautodromo.carrera to admin_apuestas;

create user admin_apuestas_pedro password '1234'
nosuperuser
nocreatedb
nocreaterole
inherit
login;
grant admin_apuestas to admin_apuestas_pedro;

create user admin_apuestas_juan password '1234'
nosuperuser
nocreatedb
nocreaterole
inherit
login;
grant admin_apuestas to admin_apuestas_pedro;
----------------------------------------------------------------------------
create role admin_pilotos
nosuperuser
nocreatedb
nocreaterole
inherit;

grant usage on schema scautodromo to admin_pilotos;

grant select on table scautodromo.auto to admin_pilotos;
grant insert on table scautodromo.auto to admin_pilotos;
grant update on table scautodromo.auto to admin_pilotos;
grant delete on table scautodromo.auto to admin_pilotos;
grant select on table scautodromo.piloto to admin_pilotos;
grant insert on table scautodromo.piloto to admin_pilotos;
grant update on table scautodromo.piloto to admin_pilotos;
grant delete on table scautodromo.piloto to admin_pilotos;
grant select on table scautodromo.carrera to admin_pilotos;
grant insert on table scautodromo.carrera to admin_pilotos;

create user admin_pilotos_daniel password '1234'
nosuperuser
nocreatedb
nocreaterole
inherit
login;
grant admin_pilotos to admin_pilotos_daniel;

create user admin_pilotos_jorge password '1234'
nosuperuser
nocreatedb
nocreaterole
inherit
login;
grant admin_pilotos to admin_pilotos_jorge;
----------------------------------------------------------------------------
create role cliente
nosuperuser
nocreatedb
nocreaterole
inherit;

grant usage on schema scautodromo to cliente;

grant insert on table scautodromo.apuesta to cliente;
grant select on table scautodromo.auesta to cliente;

create user cliente_generico --no lleva contraseña o si?
nosuperuser
nocreatedb
nocreaterole
inherit
login;
grant cliente to cliente_generico;