-- select * from usuario

-- select * from lista

-- insert into lista(nome, usuario_login) values ("Rock", "Daniel")

-- delete from lista where nome = 'Eletronica'

-- SELECT m.id,m.nome,m.cantor,m.nome_arquivo,m.album_id FROM musica m
-- JOIN musica_da_lista ml on ml.musica_id = m.id
-- WHERE ml.lista_id = 1musica_da_listamusica_da_lista

-- DELETE FROM musica_da_lista WHERE lista_id = 1 AND musica_id = 2

-- INSERT INTO album(nome) values('Bocas Ordinárias'), ('A Thousand Suns'), ('Acústico no Rio de Janeiro'), ('animals')

-- SELECT * FROM album

-- INSERT INTO musica(nome, cantor, nome_arquivo, album_id) values ('Iridescent','Linkin Park','../Musicas/Iridescent.mp3',2), ('Não Uso Sapato','Charlie Brown Jr.','../Musicas/Não Uso Sapato.mp3',1), ('O que é da Casa é da Casa  Papo Reto','Charlie Brown Jr.','../Musicas/O que é da Casa é da Casa  Papo Reto.mp3',1), ('Só por uma Noite','Charlie Brown Jr.','../Musicas/Só por uma Noite.mp3',1), ('The Catalyst','Linkin Park','../Musicas/The Catalyst.mp3',2), ('Horse','Cavalo', '../Musicas/horse.mp3', 4), ('Andei Só','Natiruts','../Musicas/Andei Só.mp3',3)

-- SELECT * FROM musica

-- SELECT * FROM musica_da_lista

-- INSERT  INTO musica_da_lista (lista_id, musica_id, qtde_vezes_tocada) SELECT 1, m.id,0 FROM album a JOIN musica m ON m.album_id  = a.id WHERE a.id = 4