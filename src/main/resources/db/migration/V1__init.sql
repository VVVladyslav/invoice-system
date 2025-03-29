CREATE TABLE type_of_payment (
                                 id BIGINT IDENTITY(1,1) PRIMARY KEY,
                                 name NVARCHAR(255) NOT NULL
);
ALTER TABLE type_of_payment
    ADD description NVARCHAR(500);
