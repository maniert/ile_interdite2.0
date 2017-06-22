
import java.util.ArrayList;
import java.util.HashMap;
    private JButton[] btnMainJoueur = new JButton[5];
    private JButton[] btnMainJoueur2 = new JButton[5];
    private JButton[] btnMainJoueur = new JButton[10];
    private JPanel mainAutre;
    private JPanel btnMainJ;
     private Integer niveau ;
    
     HashMap<Integer, JPanel> panelsGauches ;
    private final JPanel niveauPan;
    private VueAutresJoueurs mainAutre;
    private TasCartesTrésor tasCartesTrésor;
    private boolean deffausseCT = false;


        // ========================= 
        //Instanciation fenètre
        mainAutre = new VueAutresJoueurs(o, grille);
        this.btnDeplacer = new JButton("Se Déplacer");
        this.btnAssecher = new JButton("Assecher");
        this.btnActionSpecial = new JButton("Action Spécial");
        this.btnTerminerTour = new JButton("Fin Action");
        this.btnObtenirTresor = new JButton("Donner Tresor");
        panelBoutons.add(btnDeplacer);
        panelBoutons.add(btnAssecher);
        panelBoutons.add(btnActionSpecial);
        panelBoutons.add(btnObtenirTresor);
        panelBoutons.add(btnTerminerTour);
        mainPanel.add(panelBoutons, BorderLayout.EAST);

        // =========================================================
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.EAST);

        //grille.getEchelle().getNiveauEchelle(), 
        
        int niveauInitial = grille.getEchelle().getNiveauEchelle();
          panelsGauches = new HashMap<>();

        niveauPan  = new JPanel(new BorderLayout());

        niveauPan.setLayout(new BorderLayout());
        niveauPan.setBackground(Color.WHITE);
        niveauPan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
        
        JLabel labelTitre = new JLabel("Niveau", JLabel.CENTER);
        niveauPan.add(labelTitre, BorderLayout.NORTH);
        labelTitre.setFont(labelTitre.getFont().deriveFont(Font.BOLD));
        labelTitre.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
        
        JPanel panelNiveaux = new JPanel(new GridBagLayout());
        panelNiveaux.setOpaque(false);
        niveauPan.add(panelNiveaux, BorderLayout.CENTER);
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 2 ;
        c.weighty = 10 ;
        c.insets = new Insets(0, 0, 0, 0);
        c.fill = GridBagConstraints.VERTICAL ;
        
        // Insertion de la cellule gauche de niveauInitial 10
        for (int i=0; i < 10; i++) {
            c.gridx = 0 ;
            c.gridy = i ;
            JPanel panelGauche = new JPanel();
            panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));
            panelGauche.setBackground(getBgColor(10-i));
            panelGauche.setPreferredSize(new Dimension(50, 50));
            if (i < 9) {
                panelGauche.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
            } else {
                panelGauche.setBorder(new MatteBorder(1, 0, 0, 0, Color.WHITE));
            }

            panelNiveaux.add(panelGauche, c);

            JLabel labelGauche = new JLabel("", JLabel.LEFT);
            labelGauche.setPreferredSize(new Dimension(50, 50));
            labelGauche.setForeground(i==0 ? new Color(223, 168, 169) : Color.BLACK);
            labelGauche.setFont(new Font(labelGauche.getFont().getFamily(), labelGauche.getFont().getStyle(), 8));
            labelGauche.setText(getLibelle(10-i));
            panelGauche.add(labelGauche);
            panelsGauches.put((10-i), panelGauche) ;
        }
            
        // Insertion de la cellule droite de niveauInitial 10
        for (int iPanel=0; iPanel < 4; iPanel++) {
            c.gridx = 1 ;
            c.gridy = (iPanel==0 ? 0 : (iPanel==1 ? 3 : (iPanel==2 ? 5 : 8))) ;
            c.gridheight = (iPanel==0 || iPanel==2 ? 3 : 2) ;
            JPanel panelDroit = new JPanel();
            panelDroit.setPreferredSize(new Dimension(50, 50));
            panelDroit.setLayout(new GridBagLayout());
            panelNiveaux.add(panelDroit, c);

            JLabel labelDroit;
            switch (iPanel) {
                case 0:
                    panelDroit.setBackground(getBgColor(10));
                    labelDroit = new JLabel("5", JLabel.CENTER) ;
                    break;
                case 1:
                    panelDroit.setBackground(getBgColor(7));
                    labelDroit = new JLabel("4", JLabel.CENTER) ;
                    break;
                case 2:
                    panelDroit.setBackground(getBgColor(5));
                    labelDroit = new JLabel("3", JLabel.CENTER) ;
                    break;
                default:
                    panelDroit.setBackground(getBgColor(1));
                    labelDroit = new JLabel("2", JLabel.CENTER) ;
                    break;
            }
            labelDroit.setPreferredSize(new Dimension(50, 50));
            labelDroit.setForeground(Color.WHITE);
            labelDroit.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 40));
            GridBagConstraints gbc = new GridBagConstraints();
            panelDroit.add(labelDroit, gbc);
        }
        panelsGauches.get(niveauInitial).setBackground(Color.YELLOW);

        mainPanel.add(niveauPan, BorderLayout.WEST);
        // =========================================================
        mainAutre.setPreferredSize(new Dimension(500, 500));
        mainPanel.add(mainAutre, BorderLayout.WEST);

        this.mainJoueur = new JPanel(new GridLayout(1,0)); 
        this.mainJoueur = new JPanel(new GridLayout(2, 4));
       
        for (int i = 0; i <= 4; i++) {
        mainPanel.add(this.mainJoueur, BorderLayout.SOUTH);
        for (int i = 0; i <= 9; i++) {
        }
       
        this.mainJoueur2 = new JPanel(new GridLayout(1,0));
        
        for (int i = 0; i <=4; i++) {
            btnMainJoueur2[i] = new JButton();
            btnMainJoueur2[i].setName(Integer.toString(i));
              mainJoueur2.add(btnMainJoueur2[i]);
        }

        
           
        }

        // West : Main du Joueur
        this.btnMainJ = new JPanel(new GridLayout(3,1));
        btnMainJ.add(btnPiocherCTrésors);
        btnMainJ.add(btnDéfausseCTrésors);
        btnMainJ.add(btnDonnerCTrésors);
        
        mainJoueuradd = new JPanel(new BorderLayout());
        mainJoueuradd.add(btnMainJ, BorderLayout.EAST);
        mainJoueuradd.add(mainJoueur2, BorderLayout.CENTER);
                mainJoueuradd.add(mainJoueur, BorderLayout.CENTER);

mainPanel.add(mainJoueuradd, BorderLayout.SOUTH);
        
        
        mainJoueur.add(btnPiocherCTrésors, BorderLayout.WEST);
        mainJoueur.add(btnDéfausseCTrésors, BorderLayout.WEST);
        mainJoueur.add(btnDonnerCTrésors, BorderLayout.WEST);

        this.btnDeplacer = new JButton("Se Déplacer");
        this.btnAssecher = new JButton("Assecher");
        this.btnActionSpecial = new JButton("Action Spécial");
        this.btnTerminerTour = new JButton("Fin Action");
        this.btnObtenirTresor = new JButton("Donner Tresor");

        this.panelBoutons.add(btnDeplacer);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnActionSpecial);
        this.panelBoutons.add(btnObtenirTresor);
        this.panelBoutons.add(btnTerminerTour);

        peinture(grille, grille.getJoueurCourant(), couleur, white);

        peinture(grille, couleur, white, mainAutre, false);



        tasCartesTrésor = new TasCartesTrésor();
                if (grille.getJoueurCourant().getNbPA() == 0) {
                    System.out.println("tu ne peux plus te déplacer");
                } else {
                    plateau.removeAll();
                    white = false;
                    peinture(grille, grille.getJoueurCourant(), couleur, white);
                    m.type = TypesMessages.DEMANDE_DEPLACEMENT;
                    o.traiterMessage(m);
                    plateau.removeAll();
                    white = true;
                    peinture(grille, grille.getJoueurCourant(), couleur, white);
                }
                if (grille.getJoueurCourant().getNbPA() == 0) {
                    System.out.println("tu ne peux plus te déplacer");
                } else {
                    plateau.removeAll();
                    white = false;
                    peinture(grille, couleur, white, mainAutre, false);
                    m.type = TypesMessages.DEMANDE_DEPLACEMENT;
                    o.traiterMessage(m);
                    plateau.removeAll();
                    white = true;
                    peinture(grille, couleur, white, mainAutre, false);
                }
                    grille.getJoueurCourant().getTuileAtteignable().clear();
                    m.type = TypesMessages.DEPLACEMENT_SPE;
                    o.traiterMessage(m);
                    plateau.removeAll();
                    white = true;
                    peinture(grille, grille.getJoueurCourant(), couleur, white);
                    grille.getJoueurCourant().getTuileAtteignable().clear();
                    m.type = TypesMessages.DEPLACEMENT_SPE;
                    o.traiterMessage(m);
                    plateau.removeAll();
                    white = true;
                    peinture(grille, couleur, white, mainAutre, false);
                if (btnTerminerTour.getText() == "Fin Action") {
                    grille.getJoueurCourant().setNbPA(0);
                } else if (btnTerminerTour.getText() == "Terminer Tour") {
                    grille.getJoueurCourant().setNbCarteTiré(0);
                if (btnTerminerTour.getText() == "Fin Action") {
                    grille.getJoueurCourant().setNbPA(0);
                } else if (btnTerminerTour.getText() == "Terminer Tour") {
                    m.type = TypesMessages.FIN_TOUR;
                    o.traiterMessage(m);
                    btnTerminerTour.setText("Fin Action");
    public void peinture(Grille grille, Aventurier joueurCourant, Color couleur, boolean white) {
            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }
            creationTuileTresor(grille, i);

            if (grille.getJoueurCourant().getNbPA() < 1) {
                getBtnTerminerTour().setText("Terminer Tour");
            } else if (grille.getJoueurCourant().getNbPA() == Aventurier.getNbmaxPa()) {
            if (grille.getJoueurCourant().getNbPA() < 1) {
                getBtnTerminerTour().setText("Terminer Tour");
            } else if (grille.getJoueurCourant().getNbPA() == grille.getJoueurCourant().getNbmaxPa()) {

            if (white && joueurCourant.existedéjà(joueurCourant.getTuileAtteignable(), grille.getTuiles().get(i))) {

            if (white && grille.getJoueurCourant().existedéjà(grille.getJoueurCourant().getTuileAtteignable(), grille.getTuiles().get(i))) {
        }

        if (grille.getJoueurCourant().getNbPA() == 0 && grille.getJoueurCourant().getNbCarteTiré() > 0) {
            btnPiocherCTrésors.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    m.type = TypesMessages.PIOCHER_CARTE_TRESOR;
                    o.traiterMessage(m);
                    for (int i = 0; i < grille.getJoueurCourant().getMain().size(); i++) {
                        System.out.println(grille.getJoueurCourant().getMain().get(i).getTypeCarte());
                    }
                }
                        @Override
                        public void mouseReleased(MouseEvent me) {
                        }
                @Override
                public void mousePressed(MouseEvent me) {
                }
                        @Override
                        public void mouseEntered(MouseEvent me) {
                        }
                @Override
                public void mouseReleased(MouseEvent me) {
                }
                        @Override
                        public void mouseExited(MouseEvent me) {
                        }
                    });
                }
            }
                @Override
                public void mouseEntered(MouseEvent me) {
                }
            if (white == true) {
                if (grille.getJoueurCourant().existedéjà((grille.getJoueurCourant().getTuileAtteignable()), grille.getTuiles().get(i)) && white == true || grille.getJoueurCourant().existedéjà((grille.getJoueurCourant().getTuileAssechable()), grille.getTuiles().get(i))) {
                    btnGrille[i].setBackground(Color.WHITE);
                }
            }
                @Override
                public void mouseExited(MouseEvent me) {
                }
            });
        }
            btnDéfausseCTrésors.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {

                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                }

                @Override
                public void mouseExited(MouseEvent me) {
                }
            });
        } else if (grille.getJoueurCourant().getNbPA() == 0 && grille.getJoueurCourant().getNbCarteTiré() == 0) {
            m.type = TypesMessages.FIN_TOUR;
            o.traiterMessage(m);
        }


                m.type = TypesMessages.DONNE_TRESOR;
                o.traiterMessage(m);

                m.type = TypesMessages.DONNE_TRESOR;
                o.traiterMessage(m);
                
                
        
    

    }
    
     public void setNiveau(Integer niveau) {
        System.out.println("VueNiveau_nopic.setNiveau(" + niveau + ")");
        panelsGauches.get(this.niveau).setBackground(getBgColor(this.niveau - 1));
        this.niveau = niveau ;
        panelsGauches.get(this.niveau).setBackground(this.niveau == 10 ? Color.RED : Color.YELLOW);
        this.niveauPan.repaint();
    }

    public Integer getNiveau() {
        return this.niveau ;
    }

    public Integer getColoredNiveau() {
        for (Integer coloredNiveau : panelsGauches.keySet()) {
            if (panelsGauches.get(coloredNiveau).getBackground() == Color.YELLOW) {
                return coloredNiveau;
            }
        }
        return -1 ;
    }

    private Color getBgColor(Integer niveau) {
        if (niveau <= 2)
            return new Color(169, 215, 226) ;
        
        if (niveau <= 5)
            return new Color(129, 194, 212) ;
            
        
        if (niveau <= 7)
            return new Color(67, 119, 204) ;
        
        return new Color(42, 76, 127) ;
    }

    private String getLibelle(int i) {
        switch (i) {
            case 1 : 
                return " novice" ;
            case 2 : 
                return " normal" ;
            case 3 : 
                return " élite" ;
            case 4 : 
                return " légendaire" ;
            case 10 : 
                return " mortel" ;
            default :
                return "" ;
        }

    public String setImageCarte(Carte c) {
        switch (c.getTypeCarte()) {
            case MonteesDesEaux:
                return "MonteesDesEaux.jpg";
            case helicoptere:
                return "Helicoptere.jpg";
            case la_Pierre_sacrée:
                return "Pierre.jpg";
            case la_Statue_du_Zéphyr:
                return "Zephyr.jpg";
            case le_Calice_de_londe:
                return "Calice.jpg";
            case le_Cristal_Ardent:
                return "Cristal.jpg";
            case sacDeSable:
                return "SacDeSable.jpg";
        }
        return "";// si levé d'exception ici cela signifie qu'une carte est vide alors nullPoinrerExcetpion
    }
