﻿# ProjectJavaAPI5877

1. POST Upload Vehicle Information	

http://localhost:8080/api/obdapi/vehicles

{
  "vin": "ABC123",
  "make": "Toyota",
  "model": "Camry",
  "year": 2020
}


2. POST Upload Diagnostics Log

http://localhost:8080/api/obdapi/vehicles/ABC123/diagnostic-logs

{
  "rawData": "Cylinder Misfire"
}


3. POST Upload Maintenance Log

http://localhost:8080/api/obdapi/vehicles/ABC123/maintenance-logs

{
  "description": "Brake pad replacement",
  "date": "2025-05-30"
}

4. GET Diagnostics Log

http://localhost:8080/api/obdapi/vehicles/ABC123/diagnostic-logs


5. GET Maintenance Log

http://localhost:8080/api/obdapi/vehicles/ABC123/maintenance-logs

6. DELETE Vehicle

http://localhost:8080/api/ob
