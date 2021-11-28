
class Main {
    public static void main(String[] args) {
        Company alif = new Company();
        alif.hireAll("operator", 180);
        alif.hireAll("manager", 80);
        alif.hireAll("topmanager", 10);
        System.out.println("\n15 Lowest\n");
        alif.printStuffLowestSalary(15);
        System.out.println("\n30 Top\n");
        alif.printStuffTopSalary(30);
        int size = (alif.getListOfManagers().size() + alif.getListOfTopManagers().size() + alif.getListOfOperators().size()) / 2;
        int i = 0, j = 0, k = 0;
        for (; i < (size / 3) && alif.getListOfTopManagers().size() != 0; i++) {
            alif.fire("topmanager", 0);
        }

        for (; j < (size / 3) && alif.getListOfManagers().size() != 0; j++) {
            alif.fire("manager", 0);
        }

        for (; k < (size / 3) && alif.getListOfOperators().size() != 0; k++) {
            alif.fire("operators", 0);
        }

        for (; (i + k + j) < size && alif.getListOfOperators().size() != 0; i++, k++, j++) {
            alif.fire("operators", 0);
        }

        for (; (i + k + j) < size && alif.getListOfManagers().size() != 0; i++, k++, j++) {
            alif.fire("managers", 0);
        }

        System.out.println("\n15 Lowest after deleting 50% of employee\n");
        alif.printStuffLowestSalary(15);
        System.out.println("\n30 Top after deleting 50% of employee\n");
        alif.printStuffTopSalary(30);

    }
}