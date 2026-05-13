class Categorie {
  final int id;
  final String nom;

  Categorie({required this.id, required this.nom});

  factory Categorie.fromJson(Map<String, dynamic> json) {
    return Categorie(
      id: json['id'],
      nom: json['nom'],
    );
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Categorie && other.id == id;

  @override
  int get hashCode => id.hashCode;
}