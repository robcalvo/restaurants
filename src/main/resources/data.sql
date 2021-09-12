insert into restaurant (id, name, address, phone) values(restaurant_seq.nextval, 'Bistro', 'Gran vía 33, Madrid, Spain', '+34589856369');
insert into restaurant (id, name, address, phone) values(restaurant_seq.nextval, 'Cielo', 'Castellana 22, Madrid, Spain', '+342552376990');
insert into restaurant (id, name, address, phone) values(restaurant_seq.nextval, 'Pizza Pisa', 'Calle Alcalá 81, Madrid Spain', '+34211910086');
insert into review (id, restaurant_id, reviewer_name, comment, stars) values(review_seq.nextval, 1, 'Juan', 'Good food, cheap prices', 5);
insert into review (id, restaurant_id, reviewer_name, comment, stars) values(review_seq.nextval, 1, 'Sofia', 'Nice', 3);
insert into review (id, restaurant_id, reviewer_name, comment, stars) values(review_seq.nextval, 1, 'Manuel', 'Good chicken', 4);
insert into review (id, restaurant_id, reviewer_name, comment, stars) values(review_seq.nextval, 2, 'Pablo', 'Expensive', 2);
insert into review (id, restaurant_id, reviewer_name, comment, stars) values(review_seq.nextval, 2, 'Laura', 'I like it', 3);
