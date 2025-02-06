package com.empapp.serviceproxy;

import com.empapp.dto.Department;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name="DEPTAPP", fallback = DepartmentFallback.class)
public interface DeptServiceProxy {
    @GetMapping("departments/{name}")
    public Department getByName(@PathVariable String name);

}
