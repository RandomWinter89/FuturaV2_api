package com.example.futuratwo.repository.admin

import com.example.futuratwo.model.admin.Staff
import org.springframework.data.jpa.repository.JpaRepository

interface StaffRepository : JpaRepository<Staff, Long> {
}