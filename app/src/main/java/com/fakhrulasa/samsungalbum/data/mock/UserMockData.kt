package com.fakhrulasa.samsungalbum.data.mock

import com.fakhrulasa.samsungalbum.data.model.response.user.Address
import com.fakhrulasa.samsungalbum.data.model.response.user.Company
import com.fakhrulasa.samsungalbum.data.model.response.user.Geo
import com.fakhrulasa.samsungalbum.data.model.response.user.User

val mockUsers = listOf(
    User(
        address = Address(
            city = "Springfield",
            geo = Geo(lat = "37.7749", lng = "-122.4194"),
            street = "123 Main St",
            suite = "Apt 1",
            zipcode = "12345"
        ),
        company = Company(
            name = "TechCorp",
            catchPhrase = "Innovate and Inspire",
            bs = "technology solutions"
        ),
        email = "john.doe@example.com",
        id = 1,
        name = "John Doe",
        phone = "123-456-7890",
        username = "johndoe",
        website = "www.johndoe.com"
    ),
    User(
        address = Address(
            city = "Metropolis",
            geo = Geo(lat = "40.7128", lng = "-74.0060"),
            street = "456 Elm St",
            suite = "Suite 202",
            zipcode = "67890"
        ),
        company = Company(
            name = "Creative Minds",
            catchPhrase = "Think Different, Act Creative",
            bs = "creative services"
        ),
        email = "jane.smith@example.com",
        id = 2,
        name = "Jane Smith",
        phone = "987-654-3210",
        username = "janesmith",
        website = "www.janesmith.com"
    ),
    User(
        address = Address(
            city = "Gotham",
            geo = Geo(lat = "34.0522", lng = "-118.2437"),
            street = "789 Oak St",
            suite = "Floor 3",
            zipcode = "24680"
        ),
        company = Company(
            name = "FutureWorks",
            catchPhrase = "Building Tomorrow Today",
            bs = "futuristic development"
        ),
        email = "bruce.wayne@example.com",
        id = 3,
        name = "Bruce Wayne",
        phone = "555-555-5555",
        username = "batman",
        website = "www.wayneenterprises.com"
    ),
    User(
        address = Address(
            city = "Star City",
            geo = Geo(lat = "47.6062", lng = "-122.3321"),
            street = "321 Pine St",
            suite = "Unit 10",
            zipcode = "13579"
        ),
        company = Company(
            name = "Arrow Inc.",
            catchPhrase = "Aim for Excellence",
            bs = "archery supplies"
        ),
        email = "oliver.queen@example.com",
        id = 4,
        name = "Oliver Queen",
        phone = "222-333-4444",
        username = "greenarrow",
        website = "www.queenindustries.com"
    ),
    User(
        address = Address(
            city = "Central City",
            geo = Geo(lat = "41.8781", lng = "-87.6298"),
            street = "654 Maple St",
            suite = "Building B",
            zipcode = "98765"
        ),
        company = Company(
            name = "Speedster Solutions",
            catchPhrase = "Fast and Reliable",
            bs = "speed-based logistics"
        ),
        email = "barry.allen@example.com",
        id = 5,
        name = "Barry Allen",
        phone = "777-888-9999",
        username = "theflash",
        website = "www.flashlogistics.com"
    )
)