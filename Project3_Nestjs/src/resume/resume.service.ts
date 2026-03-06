import { Injectable } from '@nestjs/common';
import { Repository } from 'typeorm';
import { Resume } from './resume.entity';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class ResumeService {

  constructor(
    @InjectRepository(Resume)
    private repo: Repository<Resume>,
  ) {}

  findAll() {
    return this.repo.find();
  }

  findOne(id: number) {
    return this.repo.findOneBy({ id });
  }

  create(data) {
    return this.repo.save(data);
  }

  update(id: number, data) {
    return this.repo.update(id, data);
  }

  remove(id: number) {
    return this.repo.delete(id);
  }

}
