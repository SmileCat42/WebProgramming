import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity('user')
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

  @Column({ default: 'MEMBER' }) // แนะนำให้ใช้ MEMBER ตามที่คุยกันนะจ๊ะ
  user_role: string = 'MEMBER'; // กำหนดค่าเริ่มต้นที่ระดับ Class Property เลย
}