CREATE TABLE roadworks (
                           id SERIAL PRIMARY KEY,
                           road_section VARCHAR(255) NOT NULL,
                           session_number INT NOT NULL CHECK (session_number > 0),
                           start_date DATE NOT NULL,
                           contractor VARCHAR(255) NOT NULL,
                           repair_type VARCHAR(50) NOT NULL CHECK (repair_type IN ('Routine', 'Emergency', 'Upgrade'))
);
