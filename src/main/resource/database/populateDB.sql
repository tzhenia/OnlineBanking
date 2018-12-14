-- for table user_role
  INSERT INTO user_role (role) values ("admin");
  INSERT INTO user_role (role) values ("client");

-- for table user
  INSERT INTO user (email, phone, password, first_name, last_name, father_name, birthday, id_user_role)
  values ("tzhenia31@gmail.com", "1234567890", "password0", "Yevhenii", "Taranukha", "Yurievich", "1993-03-31", 1);

  INSERT INTO user (email, phone, password, first_name, last_name, father_name, birthday, id_user_role)
  values ("andry-test-777@gmail.com", "112233445", "password777", "Andry", "LastNameAndry", "FatherNameAndry", "1992-05-25", 2);

  INSERT INTO user (email, phone, password, first_name, last_name, father_name, birthday, id_user_role)
  values ("denys-test-888@gmail.com", "001122334", "password2", "Denys", "LastNameDenys", "FatherNameDenys", "1993-09-08", 2);

-- for table card_type
  INSERT INTO card_type (type) values ("Credit card");
  INSERT INTO card_type (type) values ("Deposit card");

-- for table card
  INSERT INTO card (id_user, number, id_card_type, card_name, balance, credit_limit, expiry_year, expiry_month, sum_of_credit, percent_value) values (1, 0000000000000001, 1, "Card name 1", 10000, 0, 2020, 12, 0, 35);
  INSERT INTO card (id_user, number, id_card_type, card_name, balance, credit_limit, expiry_year, expiry_month, sum_of_credit, percent_value) values (1, 0000000000000002, 1, "Card name 2", 700.11, 1000, 2021, 11, 0, 35);
  INSERT INTO card (id_user, number, id_card_type, card_name, balance, credit_limit, expiry_year, expiry_month, sum_of_credit, percent_value) values (1, 0000000000000003, 2, "Card name - deposit", 2000, 0, 2020, 12, 0, 20);
  INSERT INTO card (id_user, number, id_card_type, card_name, balance, credit_limit, expiry_year, expiry_month, sum_of_credit, percent_value) values (2, 0000000000000004, 1, "Card name 1", 344.56, 0, 2025, 07, 0, 35);
  INSERT INTO card (id_user, number, id_card_type, card_name, balance, credit_limit, expiry_year, expiry_month, sum_of_credit, percent_value) values (2, 0000000000000005, 2, "Card name - deposit", 10000, 0, 2020, 12, 0, 35);
  INSERT INTO card (id_user, number, id_card_type, card_name, balance, credit_limit, expiry_year, expiry_month, sum_of_credit, percent_value) values (3, 0000000000000006, 1, "Card name 1", 10000, 0, 2020, 12, 0, 35);
  INSERT INTO card (id_user, number, id_card_type, card_name, balance, credit_limit, expiry_year, expiry_month, sum_of_credit, percent_value) values (3, 0000000000000007, 2, "Card name - deposit", 10000, 0, 2020, 12, 0, 35);

-- for table transfer_type
  INSERT INTO transfer_type (type) values ("Transfer");
  INSERT INTO transfer_type (type) values ("Invoice");

-- for table status
  INSERT INTO status (status) values ("Waiting");
  INSERT INTO status (status) values ("Transferred");
  INSERT INTO status (status) values ("Archive");
  INSERT INTO status (status) values ("Approved");

-- for table credit_limit_request
  INSERT INTO credit_limit_request (id_card, credit_limit, id_status) values (1, 100000, 1);
  INSERT INTO credit_limit_request (id_card, credit_limit, id_status) values (4, 100, 1);

-- for table transfer
  INSERT INTO transfer (id_card_from, id_card_to, sum, note, id_transfer_type, id_status, time) values (1, 4, 100.1, "Demo transfer", 1, 2, "2018-12-15 10:22:21");
  INSERT INTO transfer (id_card_from, id_card_to, sum, note, id_transfer_type, id_status, time) values (1, 2, 1000, "Demo transfer", 1, 2, "2018-12-14 11:34:15");
  INSERT INTO transfer (id_card_from, id_card_to, sum, note, id_transfer_type, id_status, time) values (1, 6, 547.89, "Demo transfer", 1, 2, "2018-12-15 13:23:56");
  INSERT INTO transfer (id_card_from, id_card_to, sum, note, id_transfer_type, id_status, time) values (4, 6, 100.1, "Demo transfer", 1, 2, "2018-12-15 13:44:01");
  INSERT INTO transfer (id_card_from, id_card_to, sum, note, id_transfer_type, id_status, time) values (6, 1, 111, "Demo transfer", 1, 2, "2018-12-15 17:22:28");
  INSERT INTO transfer (id_card_from, id_card_to, sum, note, id_transfer_type, id_status, time) values (6, 4, 73.1, "Demo transfer", 1, 2, "2018-12-15 17:55:19");