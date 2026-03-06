import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class Doll {

  @PrimaryGeneratedColumn()
  doll_id: number;

  @Column()
  doll_name: string;

  @Column("decimal", { precision: 10, scale: 2 })
  doll_price: number;

  @Column()
  doll_picture: string;
}