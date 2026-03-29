import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity('users')
export class User {
  @PrimaryGeneratedColumn()
  user_num: number;

  @Column()
  user_id: string;

  @Column()
  user_pass: string;

  @Column()
  user_fname: string;

  @Column()
  user_lname: string;

  @Column()
  user_email: string;

  @Column({ default: 'CUSTOM' })
  user_role: string;
}