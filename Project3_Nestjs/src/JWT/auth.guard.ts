// roles.guard.ts
import { Injectable, CanActivate, ExecutionContext, ForbiddenException } from '@nestjs/common';

@Injectable()
export class RolesGuard implements CanActivate {
  canActivate(context: ExecutionContext): boolean {
    const request = context.switchToHttp().getRequest();
    const user = request.user;

    if (user && user.role === 'ADMIN') {
      return true;
    }

    // ✨ ส่งข้อความนี้กลับไป หน้าบ้านจะได้รับ data.message เป็นคำนี้จ่ะ
    throw new ForbiddenException('ขออภัยจ่ะ! เฉพาะ ADMIN เท่านั้นที่มีสิทธิ์จัดการข้อมูลส่วนนี้ 🧸');
  }
}