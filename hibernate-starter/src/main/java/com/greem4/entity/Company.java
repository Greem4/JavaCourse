package com.greem4.entity;

import lombok.*;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
@ToString(exclude = "users")
@Builder
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
//    @OrderBy(clause = "username DESC, lastname ASC")
//    @OrderBy("personalInfo.lastname")
    @OrderColumn(name = "id")
    @SortNatural
    private SortedSet<User> users = new TreeSet<>();

    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "company_locale")
    private List<LocaleInfo> locales = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        user.setCompany(this);
    }
}
