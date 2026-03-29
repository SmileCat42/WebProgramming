import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity('promotion') // ชื่อตารางใน MySQL
export class Promotion {
  @PrimaryGeneratedColumn()
  promotion_id: number; // PK ไม่ต้องโชว์

  @Column()
  promotion_name: string; // หัวเรื่อง

  @Column('text')
  promotion_detail: string; // รายละเอียด

  @Column({ type: 'date' })
  promotion_date: string; // วันที่ประกาศ

  @Column()
  promotion_picture: string; // เก็บชื่อรูปภาพ (เช่น 'promo1.jpg')
}