
-- Member와 Authority 테이블 초기화
--DELETE FROM authority;
--DELETE FROM member;

-- Member 테이블에 관리자 추가 (member_id 자동 생성)
--INSERT INTO member (username, password, name, birth_date, phone, email, gender, sms_opt_in, email_opt_in, join_date, status, course_id, location, postal_code, address, address_detail)
--VALUES 
--('admin', 'adminpassword', 'Admin User', '1980-01-01', '010-1111-1111', 'admin@example.com', 'MALE', true, true, '2023-12-08', 'ACTIVE', NULL, 'Seoul', '12345', '123 Admin St', 'Suite 1');

-- Authority 테이블에 관리자 권한 추가
--INSERT INTO authority (role_name, member_id)
--VALUES
--('ROLE_ADMIN', (SELECT member_id FROM member WHERE username = 'admin')),
--('ROLE_USER', (SELECT member_id FROM member WHERE username = 'admin'));


-- 관리자 계정 (Member) 생성
INSERT INTO member (
    member_id, username, password, name, birth_date, phone, contect, email, gender, 
    sms_opt_in, email_opt_in, join_date, status, course_id, location, postal_code, 
    address, address_detail
) VALUES (
    NEXT VALUE FOR MEMBER_SEQ, -- SEQUENCE에서 값을 가져옴
    'admin', -- username
    '$2a$10$DUMMY_PASSWORD_HASH', -- password
    '관리자', -- name
    '1980-01-01', -- birth_date
    '010-1234-5678', -- phone
    NULL, -- contect
    'admin@naver.com', -- email
    1, -- gender
    FALSE, -- sms_opt_in
    FALSE, -- email_opt_in
    CURRENT_DATE, -- join_date
    0, -- status
    NULL, -- course_id
    1, -- location
    '12345', -- postal_code
    '서울특별시 중구', -- address
    '을지로 1가' -- address_detail
);


-- 관리자 권한 (Authority) 추가
INSERT INTO authority (
    auth_id, role_name, member_id
) VALUES (
    NEXT VALUE FOR AUTHORITY_SEQ, -- auth_id
    'ADMIN', -- roleName
    (SELECT member_id FROM member WHERE username = 'admin') -- member_id (위에서 생성한 admin 계정)
);

