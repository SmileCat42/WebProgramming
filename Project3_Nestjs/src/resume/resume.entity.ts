import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class Resume {

  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  name: string;
  
 @Column()
  surname: string;

  @Column()
  address: string;

}
