rootProject.name = "currency-watcher"

include(
        "app-management-api",
        "scheduled-database-update-tool",
        "modules:http-client",
        "modules:cmn-persistence",
        "modules:cmn-exception"
)
