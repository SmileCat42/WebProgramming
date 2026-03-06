import { Injectable } from '@nestjs/common';
import { Repository } from 'typeorm';
import { Doll } from './doll.entity';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class DollService {

  constructor(
    @InjectRepository(Doll)
    private repo: Repository<Doll>,
  ) {}

  findAll() {
    return this.repo.find();
  }

  findOne(id: number) {
    return this.repo.findOneBy({ doll_id: id });
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