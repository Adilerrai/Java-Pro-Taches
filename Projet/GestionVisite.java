import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GestionVisite {
    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        afficherMenuPrincipal();
    }

    private static void afficherMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Gestion des Visites Commerciales ---");
            System.out.println("1. Gérer les entreprises");
            System.out.println("2. Gérer les commerciaux");
            System.out.println("3. Gérer les visites");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    gererEntreprises();
                    break;
                case 2:
                    gererCommercials();
                    break;
                case 3:
                    gererVisites();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void gererEntreprises() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Gestion des Entreprises ---");
            System.out.println("1. Afficher les entreprises");
            System.out.println("2. Ajouter une entreprise");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherEntreprises();
                    break;
                case 2:
                    ajouterEntreprise();
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void afficherEntreprises() {
        System.out.println("\n--- Liste des Entreprises ---");
        for (Entreprise entreprise : DataStore.entreprises) {
            System.out.println("- " + entreprise.getNom());
        }
    }

    private static void ajouterEntreprise() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'entreprise : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le type d'entreprise (1. Marché, 2. Laboratoire, 3. Pharmacie, 4. Grossiste) : ");
        int type = scanner.nextInt();

        Entreprise entreprise;
        switch (type) {
            case 1:
                entreprise = new Marche(nom);
                break;
            case 2:
                entreprise = new Laboratoire(nom);
                break;
            case 3:
                entreprise = new Pharmacie(nom);
                break;
            case 4:
                entreprise = new Grossiste(nom);
                break;
            default:
                System.out.println("Type d'entreprise invalide.");
                return;
        }

        DataStore.entreprises.add(entreprise);
        System.out.println("Entreprise ajoutée avec succès.");
    }

    private static void gererCommercials() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Gestion des Commerciaux ---");
            System.out.println("1. Afficher les commerciaux");
            System.out.println("2. Ajouter un commercial");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherCommerciaux();
                    break;
                case 2:
                    ajouterCommercial();
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void afficherCommerciaux() {
        System.out.println("\n--- Liste des Commerciaux ---");
        for (Commercial commercial : DataStore.commerciaux) {
            System.out.println("- " + commercial.getNom());
        }
    }

    private static void ajouterCommercial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom du commercial : ");
        String nom = scanner.nextLine();

        Commercial commercial = new Commercial(nom);
        DataStore.commerciaux.add(commercial);
        System.out.println("Commercial ajouté avec succès.");
    }

    private static void gererVisites() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Gestion des Visites ---");
            System.out.println("1. Afficher les visites");
            System.out.println("2. Ajouter une visite");
            System.out.println("3. Mettre à jour le statut d'une visite");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherVisites();
                    break;
                case 2:
                    ajouterVisite();
                    break;
                case 3:
                    mettreAJourStatutVisite();
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private static void afficherVisites() {
        System.out.println("\n--- Liste des Visites ---");
        for (Visite visite : DataStore.visites) {
            System.out.println("Entreprise : " + visite.getEntreprise().getNom());
            System.out.println("Commercial : " + visite.getCommercial().getNom());
            System.out.println("Date : " + visite.getDate());
            System.out.println("Résultat : " + visite.getResultat());
            System.out.println();
        }
    }

    private static void ajouterVisite() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'entreprise : ");
        String nomEntreprise = scanner.nextLine();

        Entreprise entreprise = trouverEntreprise(nomEntreprise);
        if (entreprise == null) {
            System.out.println("Entreprise introuvable.");
            return;
        }

        System.out.print("Entrez le nom du commercial : ");
        String nomCommercial = scanner.nextLine();

        Commercial commercial = trouverCommercial(nomCommercial);
        if (commercial == null) {
            System.out.println("Commercial introuvable.");
            return;
        }


        executorService.execute(() -> {
            Visite visite = new Visite(entreprise, commercial, "2021-06-01");
            DataStore.visites.add(visite);
            entreprise.ajouterVisite(visite);
            commercial.ajouterVisite(visite, "Planifiée");
            System.out.println("Visite ajoutée avec succès.");
        });
    }

    private static Entreprise trouverEntreprise(String nom) {
        for (Entreprise entreprise : DataStore.entreprises) {
            if (entreprise.getNom().equalsIgnoreCase(nom)) {
                return entreprise;
            }
        }
        return null;
    }

    private static Commercial trouverCommercial(String nom) {
        for (Commercial commercial : DataStore.commerciaux) {
            if (commercial.getNom().equalsIgnoreCase(nom)) {
                return commercial;
            }
        }
        return null;
    }

    private static void mettreAJourStatutVisite() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'entreprise : ");
        String nomEntreprise = scanner.nextLine();

        Entreprise entreprise = trouverEntreprise(nomEntreprise);
        if (entreprise == null) {
            System.out.println("Entreprise introuvable.");
            return;
        }

        System.out.print("Entrez le nom du commercial : ");
        String nomCommercial = scanner.nextLine();

        Commercial commercial = trouverCommercial(nomCommercial);
        if (commercial == null) {
            System.out.println("Commercial introuvable.");
            return;
        }

        System.out.print("Entrez la date de la visite (yyyy-MM-dd) : ");
        String date = scanner.nextLine();

        Visite visite = trouverVisite(entreprise, commercial, date);
        if (visite == null) {
            System.out.println("Visite introuvable.");
            return;
        }

        System.out.print("Entrez le nouveau statut de la visite (Effectuée, Annulée) : ");
        String nouveauStatut = scanner.nextLine();

        if (nouveauStatut.equalsIgnoreCase("Effectuée")) {
            executorService.execute(() -> {
                mettreAJourStatutVisiteEnParallele(visite, nouveauStatut, entreprise, commercial);
            });
        } else if (nouveauStatut.equalsIgnoreCase("Annulée")) {
            visite.setResultat(nouveauStatut);
            commercial.mettreAJourStatut(visite, nouveauStatut);
            System.out.println("Statut de la visite mis à jour avec succès.");
        } else {
            System.out.println("Statut invalide.");
        }
    }

    private static Visite trouverVisite(Entreprise entreprise, Commercial commercial, String date) {
        for (Visite visite : entreprise.getVisites()) {
            if (visite.getCommercial().equals(commercial) && visite.getDate().equals(date)) {
                return visite;
            }
        }
        return null;
    }

    private static void mettreAJourStatutVisiteEnParallele(Visite visite, String nouveauStatut, Entreprise entreprise, Commercial commercial) {
        visite.setResultat(nouveauStatut);
        commercial.mettreAJourStatut(visite, nouveauStatut);

        DataStore.visites.remove(visite);
        entreprise.getVisites().remove(visite);

        System.out.println("Visite effectuée avec succès pour " + entreprise.getNom() + " par " + commercial.getNom() + " le " + visite.getDate());
    }
}
