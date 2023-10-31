Create schema `humanFriendsdb`;
use `humanFriendsdb`;

## Создаем низкоуровневые таблицы
create table cat (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table dog (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table hamster (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);



create table horse (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);


create table camel (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);


create table donkey (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

## Создаем таблицы уровня выше
create table pets (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table packAnimal (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

## Создаем общую таблицу
create table humanFriend(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday Date
    );
    
## Заполняем данными низкоуровневые таблицы
    
    insert into cat (Name, Command, Birthday) values
    ('Барсик', 'Кс-кс-кс', '2015-01-02'),
    ('Мурзик', 'Кс-кс-кс', '2016-04-03'),
    ('Микаса', 'Кс-кс-кс', '2019-05-19');
    
    select * from cat;

    insert into dog (Name, Command, Birthday) values
    ('Рекс', 'Сидеть', '2015-01-01'),
    ('Хатико', 'Сидеть', '2018-07-12'),
    ('Грей', 'Сидеть', '2022-04-15');
	
    select * from dog;
 
	insert into hamster (Name, Command, Birthday) values
    ('Хома', 'Кушать', '2022-02-03'),
    ('Пушок', 'Кушать', '2017-11-11'),
    ('Милаш', 'Кушать', '2022-12-12');
	
    select * from hamster;
     
	insert into camel (Name, Command, Birthday) values
    ('Агата', 'Пить', '2019-10-01'),
    ('Чайна', 'Пить', '2017-11-06'),
    ('Твист', 'Пить', '2020-05-17');
	
    select * from camel;
     
	insert into horse (Name, Command, Birthday) values
    ('Барс', 'Вперед', '2022-01-01'),
    ('Победа', 'Вперед', '2017-06-06'),
    ('Сила', 'Вперед', '2021-03-17');
	
    select * from horse;    
     
	insert into donkey (Name, Command, Birthday) values
    ('Сириль', 'Стоять', '2000-01-01'),
    ('Кармела ', 'Стоять', '2018-09-19'),
    ('Лари', 'Стоять', '2019-10-17');
	
    select * from donkey;  	
 
 ## Удаление таблицы верблюдов
 delete from camel where id > 0;
 select * from camel;
 
## Объединение таблицы лошадей и ослов в одну таблицу.
create table packAnimalNew (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Command, 
        Birthday
from horse union 
select  Name, 
        Command, 
        Birthday
from donkey;

select * from packAnimalNew;

## Создание таблицы, в которой все животные в возрасте от 1 до 3 лет.
INSERT into pets (Name, Command, Birthday)
select  Name, 
        Command, 
        Birthday
from cat union 
select  Name, 
        Command, 
        Birthday
from dog union
select  Name, 
        Command, 
        Birthday
from hamster;
select * from pets;

INSERT into humanFriend (Name, Command, Birthday)
select  Name, 
        Command, 
        Birthday
from pets union 
select  Name, 
        Command, 
        Birthday
from packAnimalNew;
select * from humanFriend;
create table youngAnimals AS
select *
from humanFriend
WHERE Birthday BETWEEN DATE_SUB(CURRENT_DATE, INTERVAL 3 YEAR) AND DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR);
SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURRENT_DATE) AS age_in_months
FROM youngAnimals;

## Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

create table newhumanFriend (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Command,
        Birthday,
        'cat' as oldTable
from cat union 
select  Name, 
        Command, 
        Birthday,
        'dog' as oldTable
from dog union
select  Name, 
        Command, 
        Birthday,
        'hamster' as oldTable
from hamster union 
select  Name, 
        Command, 
        Birthday,
        'horse' as oldTable
from horse union 
select  Name, 
        Command, 
        Birthday,
        'donkey' as oldTable
from donkey;

select * from newhumanFriend;