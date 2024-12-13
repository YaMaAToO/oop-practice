CREATE TABLE roadworks (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           road_section VARCHAR(255) NOT NULL,
                           session_number INT NOT NULL,
                           start_date DATE NOT NULL,
                           contractor VARCHAR(255) NOT NULL,
                           repair_type VARCHAR(255) NOT NULL
);
