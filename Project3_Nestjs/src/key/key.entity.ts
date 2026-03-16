import { Entity, PrimaryGeneratedColumn, Column } from 'typeorm';

@Entity('key')
export class Key {

  @PrimaryGeneratedColumn()
  key_id: number;

  @Column()
  key_name: string;

  @Column('float')
  key_price: number;

  @Column()
  key_picture: string;

}