CREATE TABLE IF NOT EXISTS machines_entries (
  id SERIAL PRIMARY KEY,
  equipment VARCHAR(50) NOT NULL,
  sector_id INT NOT NULL,
  problem_description VARCHAR(255) NOT NULL,
  technician VARCHAR(100) NOT NULL,
  calling_id VARCHAR(10),
  serial_number VARCHAR(20),
  heritage_number VARCHAR(20),
  entry_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
