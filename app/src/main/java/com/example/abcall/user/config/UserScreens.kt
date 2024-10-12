package com.example.abcall.user.config

enum class UserScreens(val route: String) {
    SignIn("sign-in-user"),
    SignUp("sign-up-user")
}

//enum class UserScreens(val icon: ImageVector, val inBar: Boolean, val userType: UserType, val label: String) {
//    Login(Icons.Filled.Login, false, UserType.None, "Login"),
//    HomeVisitant(Icons.Filled.Home, true, UserType.Visitor, "Home"),
//    AlbumsVisitant(Icons.Filled.LibraryMusic, true, UserType.Visitor, "Albums"),
//    CollectorsVisitant(Icons.Filled.Groups, true, UserType.Visitor, "Collectors"),
//    ArtistsVisitant(Icons.Filled.Person, true, UserType.Visitor, "Artists"),
//    HomeCollector(Icons.Filled.Home, true, UserType.Collector, "Home"),
//    AlbumsCollector(Icons.Filled.LibraryMusic, true, UserType.Collector, "Albums"),
//    ArtistsCollector(Icons.Filled.Person, true, UserType.Collector, "Artists"),
//    New(Icons.Filled.Add, true, UserType.Collector, "New"),
//    Album(Icons.Filled.LibraryMusic, false, UserType.None, "Album"),
//    Artist(Icons.Filled.LibraryMusic, false, UserType.None, "Artist"),
//    Prize(Icons.Filled.Star, true, UserType.Collector, "Prize")
//}