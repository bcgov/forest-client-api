package ca.bc.gov.api.oracle.legacy.service;

import ca.bc.gov.api.oracle.legacy.AbstractTestContainerIntegrationTest;
import ca.bc.gov.api.oracle.legacy.dto.ClientPublicViewDto;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

@DisplayName("Integration Test | Client Service")
class ClientServiceIntegrationTest extends AbstractTestContainerIntegrationTest {

  @Autowired
  ClientService service;

  @ParameterizedTest
  @MethodSource("byNames")
  @DisplayName("Search by name")
  void shouldSearchByName(
      String clientName,
      String firstName,
      String middleName,
      List<String> clientCodes,
      boolean error,
      String errorMessage,
      ClientPublicViewDto success
  ) {

    StepVerifier.FirstStep<ClientPublicViewDto> test =
        StepVerifier.create(
            service.searchByNames(
                clientName,
                firstName,
                middleName,
                clientCodes,
                0,
                10
            )
        );

    if (error) {

      test
          .expectErrorMessage(errorMessage)
          .verify();
    } else {
      test
          .expectNext(success)
          .verifyComplete();
    }

  }

  private static Stream<Arguments> byNames() {
    ClientPublicViewDto clientPublicViewDto = new ClientPublicViewDto(
        "00000007",
        "bond",
        "james",
        "bond",
        "ACT",
        "I"
    );

    return
        Stream.of(
            Arguments.of(
                "bond",
                "james",
                "bond",
                List.of("I","A"),
                false,
                null,
                clientPublicViewDto
            ),
            Arguments.of(
                null,
                "james",
                "bond",
                List.of("I","A"),
                false,
                null,
                clientPublicViewDto
            ),
            Arguments.of(
                "bond",
                null,
                "bond",
                List.of("I","A"),
                false,
                null,
                clientPublicViewDto
            ),
            Arguments.of(
                "bond",
                "james",
                null,
                List.of("I","A"),
                false,
                null,
                clientPublicViewDto
            ),
            Arguments.of(
                "bond",
                "james",
                "bond",
                null,
                false,
                null,
                clientPublicViewDto
            ),
            Arguments.of(
                null,
                null,
                null,
                null,
                true,
                "400 BAD_REQUEST \"No search parameter found\"",
                null
            )
        );
  }

}