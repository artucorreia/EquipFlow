CREATE TABLE IF NOT EXISTS machines.exits (
  id SERIAL PRIMARY KEY,
  sector_id INT NOT NULL,
  technician VARCHAR(100) NOT NULL,
  solution_description VARCHAR(255) NOT NULL,
  entry_id INT NOT NULL,
  exit_at DATE NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(100) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by VARCHAR(100) DEFAULT NULL,
  deleted BOOLEAN DEFAULT FALSE NOT NULL
);
