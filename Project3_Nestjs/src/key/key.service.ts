import { Injectable } from '@nestjs/common';
import { Repository } from 'typeorm';
import { Key } from './key.entity';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class KeyService {

  constructor(
    @InjectRepository(Key)
    private keyRepo: Repository<Key>,
  ) {}

  findAll() {
    return this.keyRepo.find();
  }

  findOne(id: number) {
    return this.keyRepo.findOneBy({ key_id: id });
  }

  create(data) {
    return this.keyRepo.save(data);
  }

  update(id: number, data) {
    return this.keyRepo.update(id, data);
  }

  remove(id: number) {
    return this.keyRepo.delete(id);
  }
}