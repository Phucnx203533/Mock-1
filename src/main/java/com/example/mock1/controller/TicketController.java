package com.example.mock1.controller;

import com.example.mock1.dto.TicketDto;
import com.example.mock1.service.TicketService;
import com.example.mock1.utils.respone.CommonResult;
import com.example.mock1.utils.respone.ResCode;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ticket")
@Slf4j
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public CommonResult createNewTicket(@RequestBody @Valid  TicketDto ticketDto){
        TicketDto result = ticketService.createTicket(ticketDto) ;
        log.info("Create new ticket with id : {} successfully", result.getId());
        return CommonResult.success(result);
    }


    @GetMapping("/list")
    public CommonResult listTickets(){
        log.info("Get list ticket successfully");
        return CommonResult.success(ticketService.list());
    }

    @DeleteMapping("/{id}")
    public CommonResult deleteTicket(@PathVariable("id") UUID id){
        TicketDto result = ticketService.deleteTicket(id);
        if(result == null){
            log.info("Ticket with id  {} not exist ",id);
            return new CommonResult(ResCode.TICKET_NOT_EXISTS);
        }
        log.info("Delete ticket with id : {} successfully",id);
        return CommonResult.success(result);
    }
}
