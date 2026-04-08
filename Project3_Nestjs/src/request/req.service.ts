import { Injectable } from '@nestjs/common';
import { DataSource } from 'typeorm';

@Injectable()
export class RequestService {
  constructor(private dataSource: DataSource) {}

  async create(req_name: string, req_tel: string, req_mes: string) {
    await this.dataSource.query(
      `INSERT INTO request (req_name, req_tel, req_mes) VALUES (?, ?, ?)`,
      [req_name, req_tel, req_mes]
    );
  }
}