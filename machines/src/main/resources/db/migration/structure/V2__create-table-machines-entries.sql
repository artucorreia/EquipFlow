CREATE TABLE IF NOT EXISTS machines.entries (
  id SERIAL PRIMARY KEY,
  equipment VARCHAR(50) NOT NULL,
  sector_id INT NOT NULL,
  problem_description VARCHAR(255) NOT NULL,
  technician VARCHAR(100) NOT NULL,
  calling_id VARCHAR(15),
  serial_number VARCHAR(20),
  heritage_number VARCHAR(20),
  entry_at DATE NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(100) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by VARCHAR(100) DEFAULT NULL,
  deleted BOOLEAN DEFAULT FALSE NOT NULL
);
