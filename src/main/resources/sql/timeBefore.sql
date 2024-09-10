
create table if not exists tbl_t1 (
    col varchar(100)
);

insert into tbl_t1 (col) values ('AAAA');
insert into tbl_t1 (col) values ('BBBB');

insert into tbl_t1 (col) values ('CCCC'),
                                ('DDDD'),
                                ('EEEE');

