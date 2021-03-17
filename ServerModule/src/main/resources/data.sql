DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Clients;

CREATE TABLE Clients (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_Name VARCHAR(250) NOT NULL,
  last_Name VARCHAR(250)
);

CREATE TABLE Accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  client_id  INT NOT NULL,
  card_Pan VARCHAR(18) NOT NULL,
  card_Pin VARCHAR(4) NOT NULL,
  card_Exp DATE NOT NULL,
  balance DECIMAL(19,2) DEFAULT 0,
  foreign key (client_id) references Clients(id)
);

INSERT INTO Clients (first_Name, last_Name) VALUES
  ('Ivanov', 'Ivan'),
  ('Smirnov', 'Jorik'),
  ('Petrov', 'Petr');

INSERT INTO Accounts (client_id, card_Pan, card_Pin, card_Exp, balance) VALUES
  (1,'1111222233334444','1111','2021-12-31',0),
  (2,'5555666677778888','2222','2021-01-31',10),
  (3,'0000111122223333','3333','2021-03-20',1000),
  (1,'0000111122225555','1111','2021-03-25',5000);
