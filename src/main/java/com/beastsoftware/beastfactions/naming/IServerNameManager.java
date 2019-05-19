package com.beastsoftware.beastfactions.naming;

import java.io.IOException;
import java.util.UUID;

public interface IServerNameManager {

    UUID getName();

    boolean hasName();

    UUID initializeName() throws IOException;

}
