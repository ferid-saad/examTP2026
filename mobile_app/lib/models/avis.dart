class Avis {
  final int id;
  final String auteur;
  final String commentaire;
  final int note;

  Avis({
    required this.id,
    required this.auteur,
    required this.commentaire,
    required this.note,
  });

  factory Avis.fromJson(Map<String, dynamic> json) {
    return Avis(
      id: json['id'] ?? 0,
      auteur: json['auteur'] ?? '',
      commentaire: json['commentaire'] ?? '',
      note: json['note'] ?? 0,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'auteur': auteur,
      'commentaire': commentaire,
      'note': note,
    };
  }
}