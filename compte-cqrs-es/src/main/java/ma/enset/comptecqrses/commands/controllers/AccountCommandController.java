package ma.enset.comptecqrses.commands.controllers;

import ma.enset.comptecqrses.commonapi.commands.CreateAccountCommand;
import ma.enset.comptecqrses.commonapi.commands.CreditAccountCommand;
import ma.enset.comptecqrses.commonapi.commands.DebitAccountCommand;
import ma.enset.comptecqrses.commonapi.dtos.CreateAccountRequestDTO;
import ma.enset.comptecqrses.commonapi.dtos.CreditAccountRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commands/account")
public class AccountCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public AccountCommandController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO accountRequestDTO) {
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                accountRequestDTO.getInitialBalance(),
                accountRequestDTO.getCurrency()
        ));
    }

    @PostMapping("/credit")
    public CompletableFuture<String> creditAccount(@RequestBody CreditAccountRequestDTO creditAccountRequestDTO) {
        return commandGateway.send(new CreditAccountCommand(
                creditAccountRequestDTO.getAccountId(),
                creditAccountRequestDTO.getAmount(),
                creditAccountRequestDTO.getCurrency()
        ));
    }

    @PostMapping("/debit")
    public CompletableFuture<String> debitAccount(@RequestBody CreditAccountRequestDTO creditAccountRequestDTO) {
        return commandGateway.send(new DebitAccountCommand(
                creditAccountRequestDTO.getAccountId(),
                creditAccountRequestDTO.getAmount(),
                creditAccountRequestDTO.getCurrency()
        ));
    }

    @GetMapping("/events/{accountId}")
    public Stream getEvents(@PathVariable String accountId) {
        return eventStore.readEvents(accountId).asStream();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
